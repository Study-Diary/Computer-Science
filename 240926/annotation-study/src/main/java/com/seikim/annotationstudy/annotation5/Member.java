package com.seikim.annotationstudy.annotation5;

import lombok.Data;

@Data
public class Member {
	private final int id;
	private final String name;
	private final int age;
}

@Data
class BeforeMember {
	private final int id;
	private final int age;
	private final String name;
}

class Main {
	public static void main(String[] args) {
		Member member = new Member(1, "김정욱", 25);
		// BeforeMember member = new BeforeMember(1, "김정욱", 25);	// 컴파일 에러
	}
}