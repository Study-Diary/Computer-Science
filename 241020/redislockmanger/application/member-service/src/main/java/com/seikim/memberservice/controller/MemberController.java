package com.seikim.memberservice.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.seikim.memberservice.common.MemberRestController;
import com.seikim.memberservice.dto.MemberSaveRequest;
import com.seikim.memberservice.service.MemberService;
import com.seikim.mysqlmemberdomain.domain.Member;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@MemberRestController
public class MemberController {
	private final MemberService memberService;

	@PostMapping("/v1/member/save")
	public ResponseEntity<Integer> save(@RequestBody final MemberSaveRequest request) {
		int savedMemberId = memberService.save(request);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedMemberId);
	}

	@PutMapping("/v1/member/{memberId}/like")
	public ResponseEntity<Integer> likeCount(@PathVariable final int memberId) {
		int likeCount = memberService.addLikeCount(memberId);
		return ResponseEntity.ok(likeCount);
	}

	@GetMapping("/v1/member/{memberId}")
	public ResponseEntity<Member> get(@PathVariable final int memberId) {
		Member findMember = memberService.findById(memberId);
		return ResponseEntity.ok(findMember);
	}
}
