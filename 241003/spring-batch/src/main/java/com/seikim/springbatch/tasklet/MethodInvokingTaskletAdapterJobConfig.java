package com.seikim.springbatch.tasklet;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.support.DefaultBatchConfiguration;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.MethodInvokingTaskletAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
public class MethodInvokingTaskletAdapterJobConfig extends DefaultBatchConfiguration {
	private final String JOB_NAME = "MethodInvokingTaskletAdapterJob";
	private final String STEP_NAME = "SleepBySleepServiceStep";
	private final SleepService sleepService;

	@Bean
	public Job methodInvokingTaskletAdapterJob(
			final JobRepository jobRepository,
			final PlatformTransactionManager transactionManager
	) {
		return new JobBuilder(JOB_NAME, jobRepository)
				.start(sleepBySleepServiceStep(jobRepository, transactionManager))
				.build();
	}

	@Bean
	public Step sleepBySleepServiceStep(
			final JobRepository jobRepository,
			final PlatformTransactionManager transactionManager
	) {
		return new StepBuilder(STEP_NAME, jobRepository)
				.tasklet(sleepBySleepServiceTasklet(), transactionManager)
				.build();
	}

	@Bean
	public MethodInvokingTaskletAdapter sleepBySleepServiceTasklet() {
		MethodInvokingTaskletAdapter adapter = new MethodInvokingTaskletAdapter();
		adapter.setTargetObject(sleepService);
		adapter.setTargetMethod("sleep");
		return adapter;
	}
}
