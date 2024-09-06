package com.study.stream;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ParallelStreamTest {
	@DisplayName("병렬 스트림 테스트")
	@Test
	void parallelStreamTest() {
		List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		numbers.parallelStream()
				.filter(n -> n % 2 == 0)
				.map(n -> n * n)
				.forEach(n -> System.out.println("결과: " + n));
	}
}
