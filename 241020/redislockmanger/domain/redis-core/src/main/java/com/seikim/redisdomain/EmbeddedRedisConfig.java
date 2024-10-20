package com.seikim.redisdomain;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.seikim.redisdomain.propreties.RedisProperties;
import com.seikim.redisdomain.redis.OS;
import com.seikim.redisdomain.redis.RedisAvailablePortFindForDebian;
import com.seikim.redisdomain.redis.RedisAvailablePortFindForLinux;
import com.seikim.redisdomain.redis.RedisAvailablePortFindForMac;
import com.seikim.redisdomain.redis.RedisAvailablePortFindForUbuntu;
import com.seikim.redisdomain.redis.RedisAvailablePortFindForWindows;
import com.seikim.redisdomain.redis.RedisAvailablePortFindStrategy;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import redis.embedded.RedisServer;

@Slf4j
@Profile({"default", "local", "test"})
@RequiredArgsConstructor
@Configuration
public class EmbeddedRedisConfig {

	private static final Map<OS, RedisAvailablePortFindStrategy> map = new HashMap<>();
	private static final String OS_NAME = System.getProperty("os.name");

	static {
		map.put(OS.MAC, new RedisAvailablePortFindForMac());
		map.put(OS.WINDOWS, new RedisAvailablePortFindForWindows());
		map.put(OS.LINUX, new RedisAvailablePortFindForLinux());
		map.put(OS.UBUNTU, new RedisAvailablePortFindForUbuntu());
		map.put(OS.DEBIAN, new RedisAvailablePortFindForDebian());
	}

	private final RedisProperties redisProperties;
	private RedisServer redisServer;
	private int port;

	@PostConstruct
	private void start() throws IOException {
		RedisAvailablePortFindStrategy findAvailablePortUtils = getRedisAvailablePortFind();
		int redisPort = redisProperties.getPort();
		port = findAvailablePortUtils.isRedisRunning(redisPort)
				? findAvailablePortUtils.findAvailablePort(redisPort)
				: redisPort;
		log.info("Embedded Redis Running Port : [{}]", port);

		redisServer = new RedisServer(port);
		redisServer.start();
	}

	@PreDestroy
	private void stop() throws IOException {
		if (redisServer != null) {
			redisServer.stop();
			log.info("Embedded Redis Stopped Port : [{}]", port);
		}
	}

	private RedisAvailablePortFindStrategy getRedisAvailablePortFind() {
		if (OS.MAC.contains(OS_NAME)) {
			return new RedisAvailablePortFindForMac();
		} else if (OS.WINDOWS.contains(OS_NAME)) {
			return new RedisAvailablePortFindForWindows();
		} else if (OS.UBUNTU.contains(OS_NAME)) {
			return new RedisAvailablePortFindForUbuntu();
		} else if (OS.LINUX.contains(OS_NAME)) {
			return new RedisAvailablePortFindForLinux();
		} else if (OS.DEBIAN.contains(OS_NAME)) {
			return new RedisAvailablePortFindForDebian();
		}
		throw new IllegalArgumentException("Unsupported OS : " + OS_NAME);
	}
}
