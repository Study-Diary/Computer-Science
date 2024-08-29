package com.java.javafinal;

public class FinalMethod extends ParentFinalMethod {
	// @Override
	// public void hello() {    // 컴파일 에러
	// 	System.out.println("Hello World");
	// }
}

class ParentFinalMethod {
	public final void hello() {
		System.out.println("Parent Hello World");
	}
}