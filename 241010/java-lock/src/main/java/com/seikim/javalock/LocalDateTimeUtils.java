package com.seikim.javalock;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeUtils {
	private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");

	private LocalDateTimeUtils() {
		throw new IllegalStateException("Utility class");
	}

	public static String format(LocalDateTime localDateTime) {
		return formatter.format(localDateTime);
	}
}
