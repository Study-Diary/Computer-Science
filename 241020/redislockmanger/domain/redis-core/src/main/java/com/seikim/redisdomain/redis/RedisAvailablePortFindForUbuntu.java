package com.seikim.redisdomain.redis;

import java.io.IOException;

public class RedisAvailablePortFindForUbuntu implements RedisAvailablePortFindStrategy<OS> {
	private final RedisAvailablePortFindForMac redisAvailablePortFindForMac = new RedisAvailablePortFindForMac();

	@Override
	public OS getType() {
		return OS.UBUNTU;
	}

	@Override
	public int findAvailablePort(int redisPort) throws IOException {
		return redisAvailablePortFindForMac.findAvailablePort(redisPort);
	}

	@Override
	public boolean isRedisRunning(int redisPort) throws IOException {
		return redisAvailablePortFindForMac.isRedisRunning(redisPort);
	}
}
