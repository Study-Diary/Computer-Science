package com.java.javastatic;

public class OuterClass {
	private int[] data;

	public OuterClass(int size) {
		this.data = new int[size];
	}

	InnerClass getInnerClass() {
		return new InnerClass();
	}

	class InnerClass {
	}
}
