package com.java.javafinal;

public class FinalVariable {
	final int value = 2;

	public void update() {
		// value = 3;	// 컴파일 에러
		System.out.println(value);
	}
}
