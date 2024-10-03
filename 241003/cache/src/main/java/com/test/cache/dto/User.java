package com.test.cache.dto;

import java.io.Serializable;

import lombok.Getter;

@Getter
public class User implements Serializable {
	private String code;
	private String name;

	public User(String code, String name) {
		this.code = code;
		this.name = name;
	}
}
