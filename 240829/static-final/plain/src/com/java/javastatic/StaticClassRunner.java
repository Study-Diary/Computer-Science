package com.java.javastatic;

import java.util.ArrayList;
import java.util.List;

public class StaticClassRunner {
	public static void main(String[] args) {
		List<Object> list = new ArrayList<>();

		for (int counter = 0; counter < 50; counter++) {
			list.add(new OuterClass(100_000_000).getInnerClass());
			System.out.println(counter);
		}
	}
}
