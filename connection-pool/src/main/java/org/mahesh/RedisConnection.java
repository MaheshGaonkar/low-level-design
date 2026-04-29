package org.mahesh;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
public class RedisConnection implements Connection {
    private String host;
    private int port;

    @Override
    public void connect() {
    }

    @Override
    public void disconnect() {
    }

    @Override
    public boolean isAlive() {
        return true;
    }
}