package com.test.cache.data;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum CacheType {
	CACHE_STORE("myCache", 5 * 60, 10000);

	private final String cacheName;     // 캐시 이름
	private final int expireAfterWrite; // 만료시간
	private final int maximumSize;      // 최대 갯수
}