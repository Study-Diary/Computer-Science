package com.seikim.redisdomain.redis;

import lombok.Getter;

@Getter
public enum OS {
	MAC("Mac"),
	WINDOWS("Windows"),
	LINUX("Linux"),
	UBUNTU("Ubuntu"),
	DEBIAN("Debian"),
	;

	private final String value;

	OS(String value) {
		this.value = value;
	}

	public boolean contains(String osName) {
		return osName.contains(value);
	}
}
