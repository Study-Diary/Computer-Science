package com.seikim.javalock.lock;

import java.time.LocalDateTime;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import org.springframework.stereotype.Service;

import com.seikim.javalock.LocalDateTimeUtils;
import com.seikim.javalock.domain.Account;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class LockService {
	private final Lock lock = new ReentrantLock();

	public void balance(Account account) {
		lock.lock();
		try {
			log.info("""
							
							Balance Start Time: "{}"
							Account Id: "{}", Amount: "{}"
							""",
					LocalDateTimeUtils.format(LocalDateTime.now()), account.getId(), account.getAmount());
			Thread.sleep(1_000L);    // 1초
		} catch (Exception e) {
			Thread.currentThread().interrupt();
		} finally {
			lock.unlock();
		}
	}

	public void deposit(Account account, long amount) {
		if (lock.tryLock()) {    // Lock이 아닌 경우 점유
			try {
				Thread.sleep(1_000L);    // 1초
				account.withdraw(amount);
			} catch (Exception e) {
				Thread.currentThread().interrupt();
			} finally {
				lock.unlock();
			}
		} else {
			log.warn("Lock Account is locked");
		}
	}

	public void withdraw(Account account, long amount) {
		lock.lock();
		try {
			Thread.sleep(1_000L);    // 1초
			account.withdraw(amount);
		} catch (Exception e) {
			Thread.currentThread().interrupt();
		} finally {
			lock.unlock();
		}
	}
}
