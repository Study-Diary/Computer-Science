package com.database.index;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@ActiveProfiles("mysql")
@SpringBootTest
class MySQLMemberServiceTest {

	@Autowired
	private MemberService memberService;

	@Test
	void memberSaved() {
		for (int i = 0; i < 500_000; i++) {
			memberService.save(Member.builder()
					.name(String.valueOf(i))
					.phone("010-" + i)
					.email(i + "@gmail.com")
					.build());
		}
	}
}