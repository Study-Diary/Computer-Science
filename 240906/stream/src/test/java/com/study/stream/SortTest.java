package com.study.stream;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SortTest {

	@DisplayName("Arrays, Collections Test")
	@Test
	void arrListSortTest() {
		/* Given */
		List<Integer> list = new ArrayList<>(List.of(1, 3, 5, 4, 2, 1, 2));

		/* When */
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < list.size(); i++) {
			set.add(list.get(i));
		}

		List<Integer> list2 = new ArrayList<>(set);
		Collections.sort(list2);

		/* Then */
		Assertions.assertThat(list2).containsExactly(1, 2, 3, 4, 5);
	}

	@DisplayName("Stream Test")
	@Test
	void streamSortTest() {
		/* Given */
		List<Integer> list = new ArrayList<>(List.of(1, 3, 5, 4, 2, 1, 2));

		/* When */
		list = list.stream()
				.distinct()
				.sorted()
				.toList();

		/* Then */
		Assertions.assertThat(list).containsExactly(1, 2, 3, 4, 5);
	}
}
