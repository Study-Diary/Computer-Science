package com.example.ioc_di;

import org.springframework.stereotype.Repository;

@Repository
public class MemberRepository {

    public void save(Member member) {
        System.out.println("save member : " + member.hashCode());
    }
}
