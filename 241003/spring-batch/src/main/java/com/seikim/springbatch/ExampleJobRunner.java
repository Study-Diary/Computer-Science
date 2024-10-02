package com.seikim.springbatch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
@RequiredArgsConstructor
public class ExampleJobRunner {

	private final JobLauncher jobLauncher;
	private final Job externalClassTaskletJob;    // 실행을 원하는 Job을 교체해주시면 됩니다.

	@Bean
	public CommandLineRunner runJob() {
		return args -> {
			log.info("Starting the job...");
			jobLauncher.run(externalClassTaskletJob, new JobParametersBuilder().toJobParameters());
			log.info("Job finished.");
		};
	}
}
