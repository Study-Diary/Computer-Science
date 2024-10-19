package com.seikim.mysqlmemberdomain.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.seikim.mysqlmemberdomain.domain.Member;

public interface MemberRepository extends JpaRepository<Member, Integer> {
}
