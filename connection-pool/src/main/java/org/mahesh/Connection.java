package org.mahesh;

public interface Connection {
    void connect();
    void disconnect();
    boolean isAlive();
}
