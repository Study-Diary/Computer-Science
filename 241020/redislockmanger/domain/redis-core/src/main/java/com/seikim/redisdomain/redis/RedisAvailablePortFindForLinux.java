package com.seikim.redisdomain.redis;

import java.io.IOException;

public class RedisAvailablePortFindForLinux implements RedisAvailablePortFindStrategy<OS> {

	private final RedisAvailablePortFindForMac redisAvailablePortFindForMac = new RedisAvailablePortFindForMac();

	@Override
	public OS getType() {
		return OS.LINUX;
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
