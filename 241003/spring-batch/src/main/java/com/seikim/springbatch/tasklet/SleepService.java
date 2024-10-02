package com.seikim.springbatch.tasklet;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SleepService {
	public void sleep() throws InterruptedException {
		log.info("Sleep Start");
		Thread.sleep(500);
	}
}
