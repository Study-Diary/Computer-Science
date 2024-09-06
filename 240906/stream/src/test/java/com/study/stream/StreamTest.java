package com.study.stream;

import static org.assertj.core.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StreamTest {
	@DisplayName("데이터 소스를 변경하지 않는다.")
	@Test
	void dataSourceTest() {
		/* Given */
		int[] arr1 = {1, 3, 2, 5, 4};
		int[] arr2 = {1, 3, 2, 5, 4};

		/* When */
		Arrays.sort(arr1);

		/* Then */
		assertThat(arr1).containsExactly(1, 2, 3, 4, 5);
		assertThat(Arrays.stream(arr2).sorted().toArray()).containsExactly(1, 2, 3, 4, 5);
	}

	@DisplayName("일회용이다.")
	@Test
	void disposableTest() {
		/* Given */
		int[] arr = {1, 3, 2, 5, 4};

		/* When */
		IntStream intStream = Arrays.stream(arr).sorted();

		/* Then */
		intStream.toArray();
		/* 예외 발생! */
		assertThatCode(() -> intStream.toArray())
				.isInstanceOf(IllegalStateException.class);
	}

	@DisplayName("중간 연산")
	@Test
	void intermediateTest() {
		Stream<Integer> stream = new ArrayList<>(List.of(1, 3, 2, 5, 4)).stream();

		/* 실제로는 예외가 발생됩니다. */
		stream.distinct()    							// 중복 제거
				.filter(integer -> integer % 2 == 0)    // 조건
				.sorted()    							// 정렬
				.map(integer -> integer * 2);			// 스트림 요소를 반환
	}

	@DisplayName("최종 연산")
	@Test
	void terminalTest() {
		Stream<Integer> stream = new ArrayList<>(List.of(1, 3, 2, 5, 4)).stream();

		/* 실제로는 예외가 발생됩니다. */
		stream.toArray();
		stream.toList();
		stream.count();
	}
}
