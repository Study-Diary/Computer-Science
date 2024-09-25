package com.seikim.annotationstudy.annotation2;

/**
 * 2.1.1. 컴파일러에게 코드 작성 문법 에러를 체크하도록 정보 제공
 */
abstract class BaseEntity {
	public void print() {
		System.out.println("I'm BaseEntity");
	}

	@Deprecated
	public void fly() {
		System.out.println("I'm flying");
	}
}

public class MemberEntity extends BaseEntity {
	public static void main(String[] args) {
		MemberEntity memberEntity = new MemberEntity();
		memberEntity.fly();
	}

	@Override
	public void print() {
		System.out.println("I'm MemberEntity");
	}

	// @Override    // 컴파일에러 발생
	public void walk() {
		System.out.println("Oops!");
	}
}
