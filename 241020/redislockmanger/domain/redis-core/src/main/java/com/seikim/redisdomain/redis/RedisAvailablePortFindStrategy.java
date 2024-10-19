package com.seikim.redisdomain.redis;

import java.io.IOException;

public interface RedisAvailablePortFindStrategy<T> {
	T getType();

	int findAvailablePort(final int redisPort) throws IOException;

	boolean isRedisRunning(final int redisPort) throws IOException;
}
