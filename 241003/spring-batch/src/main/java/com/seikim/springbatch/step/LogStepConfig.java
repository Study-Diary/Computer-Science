package com.seikim.springbatch.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.support.DefaultBatchConfiguration;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class LogStepConfig extends DefaultBatchConfiguration {

	private static final String FIRST_STEP_NAME = "FirstStep";
	private static final String NEXT_STEP_NAME = "NextStep";
	private static final String LAST_STEP_NAME = "LastStep";

	@Bean
	public Step firstStep(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
		return new StepBuilder(FIRST_STEP_NAME, jobRepository)
				.tasklet((contribution, chunkContext) -> {
					log.info(">>>>>>>>>>>>>>>> First step");
					return RepeatStatus.FINISHED;
				}, transactionManager).build();
	}

	@Bean
	public Step nextStep(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
		return new StepBuilder(NEXT_STEP_NAME, jobRepository)
				.tasklet((contribution, chunkContext) -> {
					log.info(">>>>>>>>>>>>>>>> Next step");
					return RepeatStatus.FINISHED;
				}, transactionManager).build();
	}

	@Bean
	public Step lastStep(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
		return new StepBuilder(LAST_STEP_NAME, jobRepository)
				.tasklet((contribution, chunkContext) -> {
					log.info(">>>>>>>>>>>>>>>> Last step");
					return RepeatStatus.FINISHED;
				}, transactionManager).build();
	}
}
