package org.mahesh;

import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ConnectionPoolManager {
    private final BlockingQueue<PooledConnection> pool;
    private final ConcurrentHashMap<Connection, PooledConnection> allPooledConnectionMap;
    private final int maxSize;
    private final ConnectionFactory factory;

    public ConnectionPoolManager(int maxSize, ConnectionFactory factory) {
        this.maxSize = maxSize;
        this.factory = factory;
        pool = new LinkedBlockingQueue<>();
        allPooledConnectionMap = new ConcurrentHashMap<>();
    }

    public Connection getConnection(long timeoutMillis) throws InterruptedException {
        PooledConnection pooled = pool.poll();
        if (Objects.nonNull(pooled)) {
            if(pooled.getConnection().isAlive()) {
                pooled.setInUse(true);
                return pooled.getConnection();
            }
            destroy(pooled);
        }

        synchronized (this) {
            if (allPooledConnectionMap.size() < maxSize) {
                PooledConnection newConnection = createConnection();
                newConnection.setInUse(true);
                return newConnection.getConnection();
            }
        }

        pooled = pool.poll(timeoutMillis, TimeUnit.MILLISECONDS);
        if (Objects.isNull(pooled)) {
            throw new RuntimeException("Timeout waiting for connection");
        }
        return pooled.getConnection();
    }

    public void releaseConnection(Connection connection) {
        PooledConnection pooledConnection = allPooledConnectionMap.get(connection);
        if (Objects.nonNull(pooledConnection)) {
            pooledConnection.setInUse(false);
            pooledConnection.setLastUsedTime(System.currentTimeMillis());
            pool.offer(pooledConnection);
        }
    }

    private void destroy(PooledConnection pooledConnection) {
        pooledConnection.getConnection().disconnect();
        allPooledConnectionMap.remove(pooledConnection.getConnection());
    }

    private PooledConnection createConnection() {
        Connection connection = factory.create();
        connection.connect();
        PooledConnection pooledConnection = new PooledConnection(connection);
        allPooledConnectionMap.put(pooledConnection.getConnection(), pooledConnection);
        return pooledConnection;
    }
}