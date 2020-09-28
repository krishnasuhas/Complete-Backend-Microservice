package com.hasi.batch.job;

import com.hasi.batch.decider.PlaygroundDecider;
import com.hasi.batch.flow.PlaygroundFlow;
import com.hasi.batch.step.PlaygroundStep;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

@Component
public class PlaygroundJob {
    @Autowired
    PlaygroundStep playgroundStep;

    @Autowired
    PlaygroundFlow playgroundFlow;

    @Autowired
    PlaygroundDecider playgroundDecider;

    @Autowired
    JobBuilderFactory jobBuilderFactory;

    @Bean
    public Job helloWorldJob() {
        return jobBuilderFactory.get("helloWorldJob")
                .start(playgroundStep.helloWorldStep())
                .build();
    }

    @Bean
    public Job simpleTransitionJob() {
        return jobBuilderFactory.get("simpleTransitionJob")
                .start(playgroundStep.dummyStep1()).on("COMPLETED").to(playgroundStep.dummyStep3())
                .from(playgroundStep.dummyStep3()).on("COMPLETED").stopAndRestart(playgroundStep.dummyStep2())
                .from(playgroundStep.dummyStep2()).end()
                .build();
    }

    @Bean
    public Job flowFirstJob() {
        return jobBuilderFactory.get("flowFirstJob")
                .start(playgroundFlow.flow1())
                .next(playgroundStep.dummyStep3())
                .end()
                .build();
    }

    @Bean
    public Job flowLastJob() {
        return jobBuilderFactory.get("flowLastJob")
                .start(playgroundStep.dummyStep3()).on("COMPLETED").to(playgroundFlow.flow1())
                .end()
                .build();
    }

    @Bean
    public Job splitJob() {
        return jobBuilderFactory.get("splitJob")
                .start(playgroundStep.dummyStep1()).split(new SimpleAsyncTaskExecutor()).add(playgroundFlow.flow2())
                .end()
                .build();
    }

    @Bean
    public Job deciderJob() {
        return jobBuilderFactory.get("evenOddDeciderJob")
                .start(playgroundStep.dummyStep1())
                .next(playgroundDecider.oddDecider()).on("ODD").to(playgroundStep.dummyStep3())
                .from(playgroundDecider.oddDecider()).on("EVEN").to(playgroundStep.dummyStep2())
                .end()
                .build();
    }

    @Bean
    public Job childJob() {
        return jobBuilderFactory.get("childJob")
                .start(playgroundStep.dummyStep1())
                .build();
    }

    @Bean
    public Job parentJob(JobRepository jobRepository,
                         PlatformTransactionManager transactionManager) {
        return jobBuilderFactory.get("parentJob")
                .start(playgroundStep.childJobStep(jobRepository, transactionManager))
                .build();
    }

    @Bean
    public Job chunkJob() {
        return jobBuilderFactory.get("chunkJob")
                .start(playgroundStep.chunkStep())
                .build();
    }

    @Bean
    public Job statelessChunkJob() {
        return jobBuilderFactory.get("statelessChunkJob")
                .start(playgroundStep.statelessChunkStep())
                .build();
    }

    @Bean
    public Job databaseJob() {
        return jobBuilderFactory.get("databaseJob")
                .start(playgroundStep.databaseStep())
                .build();
    }
}
