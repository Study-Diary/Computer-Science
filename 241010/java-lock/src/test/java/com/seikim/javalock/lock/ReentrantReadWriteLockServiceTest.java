package com.seikim.javalock.lock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.seikim.javalock.domain.Account;

@SpringBootTest
class ReentrantReadWriteLockServiceTest {
	private final ReentrantReadWriteLockService service;

	private Account[] accounts;

	@Autowired
	public ReentrantReadWriteLockServiceTest(ReentrantReadWriteLockService service) {
		this.service = service;
	}

	@BeforeEach
	public void setUp() {
		accounts = new Account[] {
				Account.create(1, 1_000_000L),
				Account.create(2, 2_000_000L),
				Account.create(3, 3_000_000L),
				Account.create(4, 4_000_000L)
		};
	}

	@DisplayName("여려명이 계좌를 조회한다.")
	@Test
	void balanceTest() {
		ExecutorService executorService = Executors.newFixedThreadPool(4);
		for (Account account : accounts) {
			executorService.execute(() -> {
				service.balance(account);
			});
		}
		try {
			if (!executorService.awaitTermination(3, TimeUnit.SECONDS)) {
				executorService.shutdownNow();
			}
		} catch (InterruptedException e) {
			executorService.shutdownNow();
			Thread.currentThread().interrupt();
		}
	}

	@DisplayName("여려명이 계좌에 돈을 출금한다.")
	@Test
	void depositTest() {
		ExecutorService executorService = Executors.newFixedThreadPool(4);
		for (Account account : accounts) {
			executorService.execute(() -> {
				service.withdraw(account, 10000L);
			});
		}
		try {
			if (!executorService.awaitTermination(6, TimeUnit.SECONDS)) {
				executorService.shutdownNow();
			}
		} catch (InterruptedException e) {
			executorService.shutdownNow();
			Thread.currentThread().interrupt();
		}
	}
}