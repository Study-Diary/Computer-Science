package com.test.cache.service;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.test.cache.dto.User;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CacheService {
	@Cacheable(value = "myCache", key = "#user.getCode()")
	public User findUser(User user) {
		log.info("캐싱 XXX");
		return user;
	}

	@CachePut(value = "myCache", key = "#user.getCode()")
	public User putUser(User user) {
		log.info("캐싱 성공");
		return user;
	}

	@CacheEvict(value = "myCache", key = "#user.getCode()")
	public User delUser(User user) {
		log.info("삭제 성공");
		return user;
	}
}


// @Cacheable(value = "myCache", key = "#code")
// public String findUser(String code) {
// 	log.info("캐싱 XXX");
// 	return "캐싱 X";
// }
//
// @CachePut(value = "myCache", key = "#code")
// public String putUser(String code, String name) {
// 	log.info("캐싱 성공");
// 	return name;
// }
//
// @CacheEvict(value = "myCache", key = "#code")
// public String delUser(String code) {
// 	log.info("삭제 성공");
// 	return "삭제 성공";
// }