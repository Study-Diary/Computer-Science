package com.seikim.redisredlock;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Aspect
@Component
@RequiredArgsConstructor
public class RedissonLockAspect {

	private static final String REDISSON_LOCK_PREFIX = "LOCK:";

	private final RedissonClient redissonClient;
	private final AopForTransaction transaction;

	@Around(value = "@annotation(com.seikim.redisredlock.RedissonLock)")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		MethodSignature signature = (MethodSignature)joinPoint.getSignature();
		Method method = signature.getMethod();
		RedissonLock redissonLock = method.getAnnotation(RedissonLock.class);
		String key = REDISSON_LOCK_PREFIX + CustomSpringELParser
				.getDynamicValue(signature.getParameterNames(), joinPoint.getArgs(), redissonLock.key());
		RLock rLock = redissonClient.getLock(key);
		try {
			boolean available = rLock.tryLock(redissonLock.waitTime(), redissonLock.leaseTime(),
					redissonLock.timeUnit());
			if (!available) {
				return false;
			}
			return transaction.proceed(joinPoint);
		} catch (InterruptedException e) {
			throw new InterruptedException();
		} finally {
			if (rLock.isHeldByCurrentThread()) {
				rLock.unlock();
			} else {
				log.info("Redisson Lock Already UnLock ServiceName: {} Key: {}", method.getName(), key);
			}
		}
	}
}
