package com.seikim.javalock.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class Account {
	private int id;
	private long amount;

	private Account(int id, long amount) {
		this.id = id;
		this.amount = amount;
	}

	public static Account create(int id, long amount) {
		return new Account(id, amount);
	}

	public void deposit(long amount) {
		this.amount += amount;
	}

	public void withdraw(long amount) {
		this.amount -= amount;
	}
}
