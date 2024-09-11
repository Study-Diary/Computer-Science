package com.seikim.dispatcherservlet.data;

import java.time.LocalDateTime;

public record StartTimeRequest<T>(
		T body,
		LocalDateTime startTime
) {
}
