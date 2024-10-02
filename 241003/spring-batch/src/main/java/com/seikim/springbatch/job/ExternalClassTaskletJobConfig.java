package com.seikim.springbatch.job;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.support.DefaultBatchConfiguration;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import com.seikim.springbatch.tasklet.ExternalClassTasklet;

@Configuration
public class ExternalClassTaskletJobConfig extends DefaultBatchConfiguration {
	private final String JOB_NAME = "ExternalClassTaskletJob";
	private final String STEP_NAME = "ExternalClassTaskletStep";

	@Bean
	public Job externalClassTaskletJob(
			final JobRepository jobRepository,
			final PlatformTransactionManager transactionManager
	) {
		return new JobBuilder(JOB_NAME, jobRepository)
				.start(externalClassTaskletStep(jobRepository, transactionManager))
				.build();
	}

	@Bean
	public Step externalClassTaskletStep(
			final JobRepository jobRepository,
			final PlatformTransactionManager transactionManager
	) {
		return new StepBuilder(STEP_NAME, jobRepository)
				.tasklet(new ExternalClassTasklet(), transactionManager)
				.build();
	}
}
