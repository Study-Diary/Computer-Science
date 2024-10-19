package com.seikim.memberservice.service.utils;

import com.seikim.mysqlmemberdomain.domain.Member;
import com.seikim.mysqlmemberdomain.repository.MemberRepository;

public class MemberServiceUtils {
	private MemberServiceUtils() {
		throw new IllegalStateException("Utility class");
	}

	public static Member findById(MemberRepository memberRepository, int id) {
		return memberRepository.findById(id)
				.orElseThrow(() -> new IllegalArgumentException("Member not found"));
	}
}
