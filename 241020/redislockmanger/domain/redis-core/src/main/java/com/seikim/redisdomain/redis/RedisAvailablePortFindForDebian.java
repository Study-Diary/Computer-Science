package com.seikim.redisdomain.redis;

import java.io.IOException;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class RedisAvailablePortFindForDebian implements RedisAvailablePortFindStrategy<OS> {

	private final RedisAvailablePortFindForMac redisAvailablePortFindForMac = new RedisAvailablePortFindForMac();

	@Override
	public OS getType() {
		return OS.DEBIAN;
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
