package com.hasi.batch.step;

import com.hasi.batch.job.PlaygroundJob;
import com.hasi.batch.listhener.chunck.ChuckListener;
import com.hasi.batch.listhener.step.StepListener;
import com.hasi.batch.reader.PagingItemReader;
import com.hasi.batch.reader.PlayGroundListItemReader;
import com.hasi.batch.reader.StatelessItemReader;
import com.hasi.batch.writer.PlaygroundLogItemWriter;
import com.hasi.data.postgres.entity.Lawsuit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.JobStepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.repeat.RepeatStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

import java.util.Arrays;

@Slf4j
@Component
public class PlaygroundStep {

    @Autowired
    StepBuilderFactory stepBuilderFactory;

    @Autowired
    PlaygroundJob playgroundJob;

    @Autowired
    JobLauncher jobLauncher;

    @Bean
    public Step helloWorldStep() {
        return stepBuilderFactory.get("helloWorldStep")
                .listener(new StepListener())
                .tasklet((stepContribution, chunkContext) -> {
                    log.info("Hello world");
                    return RepeatStatus.FINISHED;
                }).build();
    }

    @Bean
    public Step dummyStep1() {
        return stepBuilderFactory.get("dummyStep1")
                .tasklet((stepContribution, chunkContext) -> {
                    log.info("This is step 1");
                    return RepeatStatus.FINISHED;
                }).build();
    }

    @Bean
    public Step dummyStep2() {
        return stepBuilderFactory.get("dummyStep2")
                .tasklet((stepContribution, chunkContext) -> {
                    log.info("This is step 2");
                    return RepeatStatus.FINISHED;
                }).build();
    }

    @Bean
    public Step dummyStep3() {
        return stepBuilderFactory.get("dummyStep3")
                .tasklet((stepContribution, chunkContext) -> {
                    log.info("This is step 3");
                    return RepeatStatus.FINISHED;
                }).build();
    }

    @Bean
    public Step childJobStep(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new JobStepBuilder(stepBuilderFactory.get("childJobStep")).
                job(playgroundJob.childJob())
                .launcher(jobLauncher)
                .repository(jobRepository)
                .transactionManager(transactionManager)
                .build();
    }

    @Bean
    public Step chunkStep() {
        return stepBuilderFactory.get("chunkStep")
                .<String, String>chunk(2)
                .faultTolerant()
                .listener(new ChuckListener())
                .reader(new PlayGroundListItemReader())
                .writer(new PlaygroundLogItemWriter())
                .build();
    }

    @Bean
    public Step statelessChunkStep() {
        return stepBuilderFactory.get("chunkStep")
                .<String, String>chunk(2)
                .reader(new StatelessItemReader(Arrays.asList("one", "two", "three")))
                .writer(new PlaygroundLogItemWriter())
                .build();
    }

    public Step databaseStep() {
        return stepBuilderFactory.get("databaseStep")
                .<Lawsuit, String>chunk(2)
                .reader(new PagingItemReader())
                .processor((ItemProcessor<Lawsuit, String>) Lawsuit::toString)
                .writer(new PlaygroundLogItemWriter())
                .build();
    }
}
