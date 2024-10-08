package com.seikim.javalock.semaphore;

import java.time.LocalDateTime;
import java.util.concurrent.Semaphore;

import org.springframework.stereotype.Service;

import com.seikim.javalock.LocalDateTimeUtils;
import com.seikim.javalock.domain.Account;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SemaphoreService {
	private final Semaphore semaphore = new Semaphore(2);

	public void balance(Account account) {
		try {
			semaphore.acquire();
			log.info("""
							
							Balance Start Time: "{}"
							Account Id: "{}", Amount: "{}"
							""",
					LocalDateTimeUtils.format(LocalDateTime.now()),
					account.getId(), account.getAmount());
			Thread.sleep(2_000L);    // 2초
		} catch (Exception e) {
			Thread.currentThread().interrupt();
		} finally {
			semaphore.release();
		}
	}
}
