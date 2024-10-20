package com.seikim.memberservice.actuator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RouterControllerTest {
	@Autowired
	private TestRestTemplate restTemplate;

	@Value("${spring.application.name}")
	private String applicationName;

	@DisplayName("Spring Cloud Router 테스트")
	@Test
	void routeCheckTest() {
		/* Given & When */
		ResponseEntity<String> response
				= restTemplate.getForEntity(String.format("/%s/v1/actuator/route", applicationName), String.class);

		/* Then */
		assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
		assertThat(response.getBody()).contains("OK");
	}
}