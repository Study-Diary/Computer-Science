package com.seikim.annotationstudy.anotation;

abstract class BaseEntity {
	public void print() {
		System.out.println("I'm BaseEntity");
	}
}

public class MemberEntity extends BaseEntity {
	@Override
	public void print() {
		System.out.println("I'm MemberEntity");
	}

	// @Override    // 컴파일에러 발생
	public void walk() {
		System.out.println("Oops!");
	}
}
