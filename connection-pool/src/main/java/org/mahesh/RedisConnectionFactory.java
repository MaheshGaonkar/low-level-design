package org.mahesh;

public class RedisConnectionFactory implements ConnectionFactory {
    @Override
    public Connection create() {
        return new RedisConnection();
    }
}