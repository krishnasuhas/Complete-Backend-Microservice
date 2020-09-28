package com.hasi.batch.decider;

import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.job.flow.FlowExecutionStatus;
import org.springframework.batch.core.job.flow.JobExecutionDecider;

import java.util.Random;

public class OddDecider implements JobExecutionDecider {
    private static final Random rand = new Random();

    @Override
    public FlowExecutionStatus decide(JobExecution jobExecution, StepExecution stepExecution) {
        if (rand.nextInt() % 2 == 0) return new FlowExecutionStatus("EVEN");
        else return new FlowExecutionStatus("ODD");
    }
}
