package com.seikim.javalock.mutex;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.seikim.javalock.LocalDateTimeUtils;
import com.seikim.javalock.domain.Account;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MutexService {

	public synchronized void balance(Account account) {
		try {
			log.info("""
							
							Balance Start Time: "{}"
							Account Id: "{}", Amount: "{}"
							""",
					LocalDateTimeUtils.format(LocalDateTime.now()), account.getId(), account.getAmount());
			Thread.sleep(2_000L);    // 2초
		} catch (Exception e) {
			Thread.currentThread().interrupt();
		}
	}
}
