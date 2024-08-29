package com.java.javastatic;

public class StaticRunner {
	public static void main(String[] args) {
		// 생성된 내부 클래스 인스턴스는 서로 다르다
		StaticRunner.InnerClass inner1 = new StaticRunner().new InnerClass();
		StaticRunner.InnerClass inner2 = new StaticRunner().new InnerClass();
		System.out.println(inner1 == inner2); // false

		// 생성된 내부 스태틱 클래스 인스턴스는 서로 다르다
		StaticRunner.InnerStaticClass static1 = new InnerStaticClass();
		StaticRunner.InnerStaticClass static2 = new InnerStaticClass();
		System.out.println(static1 == static2); // false
	}

	static class InnerStaticClass {
	}

	class InnerClass {
	}
}
