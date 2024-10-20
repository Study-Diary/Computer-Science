package com.seikim.memberservice.service.impl;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.seikim.memberservice.dto.MemberSaveRequest;
import com.seikim.memberservice.service.MemberService;
import com.seikim.memberservice.service.utils.MemberServiceUtils;
import com.seikim.mysqlmemberdomain.domain.Member;
import com.seikim.mysqlmemberdomain.repository.MemberRepository;
import com.seikim.redisredlock.RedissonLock;

import lombok.RequiredArgsConstructor;

@Primary
@Transactional(readOnly = true)
@RequiredArgsConstructor
@Service
public class MemberLockServiceImpl implements MemberService {

	private final MemberRepository memberRepository;

	@RedissonLock(key = "#memberId")
	@Transactional
	@Override
	public int addLikeCount(final int memberId) {
		Member findMember = MemberServiceUtils.findById(memberRepository, memberId);
		findMember.addLikeCount();
		return findMember.getLikeCount();
	}

	@Transactional
	@Override
	public int save(final MemberSaveRequest request) {
		Member member = request.toMember();
		Member savedMember = memberRepository.save(member);
		return savedMember.getId();
	}

	@Override
	public Member findById(int memberId) {
		return MemberServiceUtils.findById(memberRepository, memberId);
	}
}
