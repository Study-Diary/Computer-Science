package com.seikim.springbatch.tasklet;

import org.springframework.batch.core.ExitStatus;
import org.springframework.batch.core.StepContribution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.StepExecutionListener;
import org.springframework.batch.core.annotation.AfterStep;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.core.scope.context.ChunkContext;
import org.springframework.batch.core.step.tasklet.Tasklet;
import org.springframework.batch.repeat.RepeatStatus;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ExternalClassTasklet implements Tasklet, StepExecutionListener {
	@Override
	@BeforeStep
	public void beforeStep(StepExecution stepExecution) {
		log.info(">>>>>>>>>> Before Step Start!");
	}

	@Override
	public RepeatStatus execute(StepContribution contribution, ChunkContext chunkContext) throws Exception {
		for (int i = 0; i < 10; i++) {
			log.info(">>>>>>>>>>>>>>>>>>>> {}: Execute!", i);
		}
		return RepeatStatus.FINISHED;
	}

	@Override
	@AfterStep
	public ExitStatus afterStep(StepExecution stepExecution) {
		log.info(">>>>>>>>>> After Step Start!");
		return ExitStatus.COMPLETED;
	}
}
