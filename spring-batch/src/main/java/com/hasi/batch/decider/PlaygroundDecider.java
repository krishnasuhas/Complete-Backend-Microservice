package com.hasi.batch.decider;

import org.springframework.batch.core.job.flow.JobExecutionDecider;
import org.springframework.stereotype.Component;

@Component
public class PlaygroundDecider {

    public JobExecutionDecider oddDecider() {
        return new OddDecider();
    }
}
