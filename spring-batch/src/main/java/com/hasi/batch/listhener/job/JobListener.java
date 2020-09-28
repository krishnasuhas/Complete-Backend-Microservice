package com.hasi.batch.listhener.job;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.annotation.AfterJob;
import org.springframework.batch.core.annotation.BeforeJob;

@Slf4j
public class JobListener {

    @BeforeJob
    public void beforeJob(JobExecution jobExecution) {
        log.info("Job {} started", jobExecution.getJobInstance().getJobName());
    }

    @AfterJob
    public void AfterJob(JobExecution jobExecution) {
        log.info("Job {} finished", jobExecution.getJobInstance().getJobName());
    }
}
