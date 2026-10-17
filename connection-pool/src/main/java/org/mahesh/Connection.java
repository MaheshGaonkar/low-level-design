package org.mahesh;

import org.mahesh.enums.ConnectionType;

public interface Connection {
    void connect();
    void disconnect();
    boolean isAlive();
    ConnectionType getType();
}
