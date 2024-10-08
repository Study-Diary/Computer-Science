package com.seikim.javalock.mutex;

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
class MutexServiceTest {

	private final MutexService mutexService;

	private Account accountOne;
	private Account accountTwo;

	@Autowired
	public MutexServiceTest(MutexService mutexService) {
		this.mutexService = mutexService;
	}

	@BeforeEach
	public void setUp() {
		accountOne = Account.create(1, 1_000_000L);
		accountTwo = Account.create(2, 2_000_000L);
	}

	@DisplayName("여려명이 계좌를 조회한다.")
	@Test
	void balanceTest() {
		ExecutorService executorService = Executors.newFixedThreadPool(2);
		executorService.execute(() -> {
			mutexService.balance(accountOne);
		});
		executorService.execute(() -> {
			mutexService.balance(accountTwo);
		});
		executorService.shutdown();

		try {
			if (!executorService.awaitTermination(3, TimeUnit.SECONDS)) {
				executorService.shutdownNow();
			}
		} catch (InterruptedException e) {
			executorService.shutdownNow();
			Thread.currentThread().interrupt();
		}
	}
}