package org.mahesh;

import java.util.Objects;
import java.util.Set;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ConnectionPoolManager {
    private final BlockingQueue<PooledConnection> pool;
    private final Set<PooledConnection> allConnections;
    private final int maxSize;
    private final ConnectionFactory factory;

    public ConnectionPoolManager(int maxSize, ConnectionFactory factory) {
        this.maxSize = maxSize;
        this.factory = factory;
        pool = new LinkedBlockingQueue<>();
        allConnections = ConcurrentHashMap.newKeySet();
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
            if (allConnections.size() < maxSize) {
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
        allConnections.stream()
                .filter(pooledConnection -> pooledConnection.getConnection() == connection)
                .findFirst().ifPresent(pooledConnection -> {
                    pooledConnection.setInUse(false);
                    pooledConnection.setLastUsedTime(System.currentTimeMillis());
                    pool.offer(pooledConnection);
                });
    }

    private void destroy(PooledConnection pooledConnection) {
        pooledConnection.getConnection().disconnect();
        allConnections.remove(pooledConnection);
    }

    private PooledConnection createConnection() {
        Connection connection = factory.create();
        connection.connect();

        PooledConnection pooledConnection = new PooledConnection(connection);
        allConnections.add(pooledConnection);
        return pooledConnection;
    }
}