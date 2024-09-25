package com.seikim.spring;

import static org.assertj.core.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import lombok.extern.slf4j.Slf4j;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;

@Slf4j
@SpringBootTest
class AwsS3ClientTest {
	private final S3Client s3Client;

	public AwsS3ClientTest(@Autowired S3Client s3Client) {
		this.s3Client = s3Client;
	}

	/**
	 * `@Test`가 붙어있는 메소드는 건드리지 않고 해당 테스트를 성공시켜보세요!
	 */

	@Test
	void s3ClientInfoTest() {
		String serviceName = s3Client.serviceName();

		log.info("Service Name: {}", serviceName);

		assertThat(serviceName).isEqualTo("AWS S3 Service");
	}

	@ParameterizedTest
	@EnumSource
	void s3ClientPutTest(FileFixture fixture) throws IOException {
		RequestBody requestBody = fixture.toRequestBody();
		PutObjectRequest putObjectRequest = fixture.toPutObjectRequest();

		assertThatCode(() -> s3Client.putObject(putObjectRequest, requestBody))
				.doesNotThrowAnyException();
	}
}