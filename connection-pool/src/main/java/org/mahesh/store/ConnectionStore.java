package org.mahesh.store;

import org.mahesh.Connection;
import org.mahesh.enums.ConnectionType;

import java.util.Map;
import java.util.Set;
 import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

public abstract class ConnectionStore {
    private Map<ConnectionType, Set<Connection>> totalConnectionsMap;
    private Map<ConnectionType, Integer> maxConnectionPerConnectionTypeMap;

    public ConnectionStore(Map<ConnectionType, Integer> maxConnectionPerConnectionTypeMap) {
        this.maxConnectionPerConnectionTypeMap = maxConnectionPerConnectionTypeMap;
       // availableConnectionPool = new ConcurrentHashMap<>();
        totalConnectionsMap = new ConcurrentHashMap<>();

       // for(ConnectionType connectionType : ConnectionType.values()) {
            //availableConnectionPool.put(connectionType, new LinkedBlockingQueue<>());
           // totalConnectionsMap.put(connectionType, new ConcurrentHashMap<>());
//}
    }

    //protected Connection createAndGetConnection(ConnectionType connectionType) {

    //}
}
