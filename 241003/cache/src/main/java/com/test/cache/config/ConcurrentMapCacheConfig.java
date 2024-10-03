package com.test.cache.config;

import java.util.List;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableCaching
public class ConcurrentMapCacheConfig {

	@Bean
	public CacheManager myCacheManager() {
		ConcurrentMapCacheManager cacheManager = new ConcurrentMapCacheManager();
		cacheManager.setStoreByValue(true);
		cacheManager.setCacheNames(List.of("myCache"));

		return cacheManager;
	}
}
