package com.seikim.redisredlock;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.concurrent.TimeUnit;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface RedissonLock {
	/**
	 * 락의 이름
	 */
	String key();

	/**
	 * 락의 시간 단위
	 */
	TimeUnit timeUnit() default TimeUnit.SECONDS;

	/**
	 * 락을 기다리는 시간 (default - 5s)</br>
	 * 락 획득을 위해 waitTime 만큼 대기한다.
	 */
	long waitTime() default 5L;

	/**
	 * 락 임대 시간 (default - 3s)</br>
	 * 락을 획득한 후 leaseTime이 자나면 락을 해제한다.
	 */
	long leaseTime() default 3L;
}
