package com.seikim.springbatch;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableBatchProcessing    // 해당 어노테이션
@SpringBootApplication
public class SpringBatchApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBatchApplication.class, args);
	}

}
