package com.test.cache.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.cache.dto.User;
import com.test.cache.service.CacheService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class CacheController {
	private final CacheService cacheService;

	@GetMapping("/{code}")
	public User findUser(@PathVariable String code) {
		return cacheService.findUser(new User(code, null));
	}

	@PostMapping
	public User putUser(String code, String name) {
		return cacheService.putUser(new User(code, name));
	}

	@DeleteMapping
	public User delUser(String code) {
		return cacheService.delUser(new User(code, null));
	}
}
