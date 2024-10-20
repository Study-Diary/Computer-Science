package com.seikim.redisredlock;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.spring.data.connection.RedissonConnectionFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "spring.data.redis")
public class RedisConfig {
	private static final String REDISSON_HOST_PREFIX = "redis://";
	private String host = "127.0.0.1";
	private int port = 6379;

	@Bean
	public RedissonClient redissonClient() {
		RedissonClient redisson = null;
		Config config = new Config();
		config.useSingleServer().setAddress(REDISSON_HOST_PREFIX + host + ":" + port);
		redisson = Redisson.create(config);
		return redisson;
	}

	@Bean
	public RedissonConnectionFactory redisConnectionFactory(RedissonClient redisson) {
		return new RedissonConnectionFactory(redisson);
	}
}
