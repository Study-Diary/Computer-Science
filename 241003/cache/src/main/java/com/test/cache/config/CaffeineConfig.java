// package com.test.cache.config;
//
// import java.util.Arrays;
// import java.util.List;
// import java.util.concurrent.TimeUnit;
//
// import org.springframework.cache.CacheManager;
// import org.springframework.cache.annotation.EnableCaching;
// import org.springframework.cache.caffeine.CaffeineCache;
// import org.springframework.cache.support.SimpleCacheManager;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
//
// import com.github.benmanes.caffeine.cache.Caffeine;
// import com.test.cache.data.CacheType;
//
// @Configuration
// @EnableCaching
// public class CaffeineConfig {
// 	@Bean
// 	public List<CaffeineCache> caffeineCachesConfig() {
// 		return Arrays.stream(CacheType.values())
// 			.map(cache -> new CaffeineCache(cache.getCacheName(), Caffeine.newBuilder()
// 					.recordStats()
// 					.expireAfterWrite(cache.getExpireAfterWrite(),
// 						TimeUnit.SECONDS)
// 					.maximumSize(cache.getMaximumSize())
// 					.build()
// 				)
// 			)
// 			.toList();
// 	}
//
// 	@Bean
// 	public CacheManager cacheManager(List<CaffeineCache> caffeineCaches) {
// 		final SimpleCacheManager cacheManager = new SimpleCacheManager();
// 		cacheManager.setCaches(caffeineCaches);
// 		return cacheManager;
// 	}
// }
