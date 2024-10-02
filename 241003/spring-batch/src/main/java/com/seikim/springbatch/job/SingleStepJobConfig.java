package com.seikim.springbatch.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.support.DefaultBatchConfiguration;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import lombok.RequiredArgsConstructor;

/**
 * 3.2.1 단일 Step 구성하기
 */
@RequiredArgsConstructor
// @Configuration
public class SingleStepJobConfig extends DefaultBatchConfiguration {

	private static final String JOB_NAME = "SingleStepJob";

	private final Step firstStep;

	@Bean
	public Job singleStepJob(JobRepository jobRepository) {
		return new JobBuilder(JOB_NAME, jobRepository)
				.start(firstStep)
				.build();
	}
}
