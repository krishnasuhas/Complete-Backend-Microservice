package com.hasi.batch.listhener.step;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.AfterStep;
import org.springframework.batch.core.annotation.BeforeStep;

@Slf4j
public class StepListener {
    @BeforeStep
    public void beforeStep(StepExecution stepExecution) {
        log.info("before Step");
        log.info("parameters {}", stepExecution.getJobParameters().getParameters());
    }

    @AfterStep
    public void afterStep(StepExecution stepExecution) {
        log.info("after Step");
    }
}
