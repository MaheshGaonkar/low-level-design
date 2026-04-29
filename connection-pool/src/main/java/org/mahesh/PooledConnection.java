package org.mahesh;

import lombok.Getter;
import lombok.Setter;

public class PooledConnection {
    @Getter
    private final Connection connection;
    @Setter
    private long lastUsedTime;
    @Setter
    private boolean inUse;

    public PooledConnection(Connection connection) {
        this.connection = connection;
    }
}