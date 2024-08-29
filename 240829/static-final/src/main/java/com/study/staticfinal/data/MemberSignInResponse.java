package com.study.staticfinal.data;

import com.study.staticfinal.domain.Member;

public record MemberSignInResponse(
		long id,
		String email
) {
	public static MemberSignInResponse from(Member savedMember) {
		return new MemberSignInResponse(savedMember.getId(), savedMember.getEmail());
	}
}
