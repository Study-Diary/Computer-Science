package com.study.stream;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.util.StopWatch;

class PerformanceTest {
	private final List<Integer> list;
	private StopWatch stopWatch;

	public PerformanceTest() {
		this.list = new ArrayList<>();
		for (int i = 0; i < 10_000_000; i++) {
			list.add(i);
		}
		for (int i = 0; i < 10_000_000; i += 3) {
			list.add(i);
		}
	}

	@BeforeEach
	public void before() {
		stopWatch = new StopWatch();
	}

	@AfterEach
	public void after() {
		stopWatch.stop();
		System.out.println(stopWatch.prettyPrint());
	}

	@DisplayName("for loop 성능 테스트")
	@Test
	void forPerformanceTest() {
		stopWatch.start("For Loop Performance");
		List<Integer> list = new ArrayList<>();
		Set<Integer> uniqueValues = new HashSet<>();
		for (Integer integer : this.list) {
			if (uniqueValues.add(integer)) {
				if (integer % 2 == 0) {
					list.add(integer);
				}
			}
		}
	}

	@DisplayName("Stream 성능 테스트")
	@Test
	void streamPerformanceTest() {
		stopWatch.start("Stream API Performance");
		List<Integer> list = this.list.stream()
				.distinct()
				.filter(integer -> integer % 2 == 0)
				.toList();
	}
}
