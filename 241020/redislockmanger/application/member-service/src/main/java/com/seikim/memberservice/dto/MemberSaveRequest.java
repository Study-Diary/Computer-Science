package com.seikim.memberservice.dto;

import com.seikim.mysqlmemberdomain.domain.Member;

public record MemberSaveRequest(
		String email,
		String username
) {
	public Member toMember() {
		return new Member(email, username);
	}
}
