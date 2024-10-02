package com.seikim.springbatch.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.support.DefaultBatchConfiguration;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * 3.2.2 다중 Step 구성하기
 */
@Slf4j
@RequiredArgsConstructor
// @Configuration
public class MultiStepJobConfig extends DefaultBatchConfiguration {

	private static final String JOB_NAME = "MultiStepJob";

	private final Step firstStep;
	private final Step nextStep;
	private final Step lastStep;

	@Bean
	public Job multiStepJob(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
		return new JobBuilder(JOB_NAME, jobRepository)
				.start(firstStep)
				.next(nextStep)
				.next(lastStep)
				.build();
	}
}
