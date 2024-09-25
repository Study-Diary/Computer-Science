package com.seikim.annotationstudy.annotation3;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.ThreadLocalRandom;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.StopWatch;

import lombok.extern.slf4j.Slf4j;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface MethodTimer {
}

@Slf4j
@Component
@Aspect
class MethodTimerAspect {
	private final ThreadLocal<StopWatch> stopWatchThreadLocal = new ThreadLocal<>();

	@Around("@annotation(com.seikim.annotationstudy.annotation3.MethodTimer)")
	public Object process(ProceedingJoinPoint joinPoint) throws Throwable {
		stopWatchThreadLocal.set(new StopWatch());
		StopWatch stopWatch = stopWatchThreadLocal.get();
		stopWatch.start();
		try {
			Object proceed = joinPoint.proceed();

			stopWatch.stop();
			log.info(stopWatch.prettyPrint());

			return proceed;
		} catch (Throwable t) {
			stopWatch.stop();
			log.error(stopWatch.prettyPrint());

			throw t;
		} finally {
			stopWatchThreadLocal.remove();
		}
	}
}

@Service
class TimerService {

	@MethodTimer
	public void sleep() throws InterruptedException {
		Thread.sleep(1_000L * (ThreadLocalRandom.current().nextInt(3) + 1));
	}

	@MethodTimer
	public void sleepFail() throws InterruptedException {
		Thread.sleep(1_000L * (ThreadLocalRandom.current().nextInt(3) + 1));
		throw new InterruptedException();
	}
}