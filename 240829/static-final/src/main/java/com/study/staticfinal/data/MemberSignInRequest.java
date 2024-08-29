package com.study.staticfinal.data;

import com.study.staticfinal.common.PasswordUtils;
import com.study.staticfinal.domain.Gender;
import com.study.staticfinal.domain.Member;

public record MemberSignInRequest(
		String email,
		String password,
		int age,
		String name,
		Gender gender
) {
	public Member toMember() {
		return Member.builder()
				.email(email)
				.password(PasswordUtils.encode(password))
				.age(age)
				.name(name)
				.gender(gender)
				.build();
	}
}
