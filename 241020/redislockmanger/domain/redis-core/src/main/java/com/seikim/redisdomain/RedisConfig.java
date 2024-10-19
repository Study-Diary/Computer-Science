package com.seikim.redisdomain;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

import com.seikim.redisdomain.propreties.RedisProperties;

import lombok.RequiredArgsConstructor;

@Profile({"dev", "prod"})
@EnableRedisRepositories
@RequiredArgsConstructor
@Configuration
public class RedisConfig {
	private final RedisProperties redisProperties;

	@Bean
	public RedisConnectionFactory redisConnectionFactory() {
		RedisStandaloneConfiguration redisConfiguration
				= new RedisStandaloneConfiguration(redisProperties.getHost(), redisProperties.getPort());
		redisConfiguration.setPassword(redisProperties.getPassword());
		return new LettuceConnectionFactory(redisConfiguration);
	}

	@Bean
	public RedisTemplate<byte[], byte[]> redisTemplate() {
		RedisTemplate<byte[], byte[]> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(redisConnectionFactory());
		return redisTemplate;
	}
}
