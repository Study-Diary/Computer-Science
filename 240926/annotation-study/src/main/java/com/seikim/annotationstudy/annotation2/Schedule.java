package com.seikim.annotationstudy.annotation2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

import lombok.SneakyThrows;

@Repeatable(Schedules.class)
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface Schedule {
	String day();
}

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface Schedules {
	Schedule[] value();
}

class Event {
	@SneakyThrows
	public static void main(String[] args) {
		Method method = Event.class.getMethod("scheduledEvent");

		Schedule[] schedules = method.getAnnotationsByType(Schedule.class);

		for (Schedule schedule : schedules) {
			System.out.printf("Schedule: %s\n", schedule.day());
		}

		/**
		 * Output
		 * Schedule: Monday
		 * Schedule: Wednesday
		 * Schedule: Friday
		 */
	}

	@Schedule(day = "Monday")
	@Schedule(day = "Wednesday")
	@Schedule(day = "Friday")
	public void scheduledEvent() {
	}
}