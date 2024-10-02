package com.seikim.springbatch.step;

import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.support.DefaultBatchConfiguration;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Configuration
public class VariousStepSettingConfig extends DefaultBatchConfiguration {
	private static final String START_LIMIT_STEP_NAME = "startLimitStep";
	private static final String SKIP_STEP_NAME = "skipStep";
	private static final String RETRY_STEP_NAME = "retryStep";
	private static final String NO_ROLLBACK_STEP_NAME = "noRollbackStep";

	@Bean
	public Step startLimitStep(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
		return new StepBuilder(START_LIMIT_STEP_NAME, jobRepository)
				.tasklet(tasklet(), transactionManager)
				.startLimit(10)    // 10번 재시작 가능
				.build();
	}

	/**
	 * 4.1.1
	 */
	public Tasklet tasklet() {
		return ((contribution, chunkContext) -> {
			log.info(">>>>>>>>>>>>>>>> Step");
			return RepeatStatus.FINISHED;
		});
	}
}
