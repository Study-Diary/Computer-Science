package com.seikim.memberservice.service;

import com.seikim.memberservice.dto.MemberSaveRequest;
import com.seikim.mysqlmemberdomain.domain.Member;

public interface MemberService {

	int save(MemberSaveRequest request);

	int addLikeCount(int memberId);

	Member findById(int memberId);
}
