package com.seikim.annotationstudy.annotation3;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TimerServiceTest {
	@Autowired
	private TimerService timerService;

	@Test
	void timerTest() throws InterruptedException {
		for (int i = 0; i < 3; i++) {
			timerService.sleep();
		}
	}

	@Test
	void timerFailTest() {
		for (int i = 0; i < 3; i++) {
			try {
				timerService.sleepFail();
			} catch (InterruptedException e) {
			}
		}
	}
}