package com.example.ioc_di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberService {

    private MemberRepository memberRepository;

    @Autowired
    public void init(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

//    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public void join(Member member) {
        memberRepository.save(member);
    }

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }


}
