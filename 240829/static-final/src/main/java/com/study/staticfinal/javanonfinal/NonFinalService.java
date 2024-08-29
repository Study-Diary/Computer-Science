package com.study.staticfinal.javanonfinal;

import org.springframework.stereotype.Service;

import com.study.staticfinal.common.Transaction;
import com.study.staticfinal.data.MemberSignInRequest;
import com.study.staticfinal.data.MemberSignInResponse;
import com.study.staticfinal.domain.Member;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class NonFinalService {
	private final NonFinalMemberRepository finalRepository;

	@Transaction
	public MemberSignInResponse saveMember(MemberSignInRequest request) {
		Member member = request.toMember();
		Member savedMember = finalRepository.save(member);
		return MemberSignInResponse.from(savedMember);
	}
}