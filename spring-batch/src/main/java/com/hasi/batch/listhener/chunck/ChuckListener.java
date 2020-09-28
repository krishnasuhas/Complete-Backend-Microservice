package com.hasi.batch.listhener.chunck;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.annotation.AfterChunk;
import org.springframework.batch.core.annotation.BeforeChunk;
import org.springframework.batch.core.scope.context.ChunkContext;

@Slf4j
public class ChuckListener {

    @BeforeChunk
    public void beforeChunk(ChunkContext context) {
        log.info("before Chunck for job {}", context.getStepContext().getStepExecution().getJobExecution().getJobInstance().getJobName());
    }

    @AfterChunk
    public void afterChunk(ChunkContext context) {
        log.info("after Chunck for job {}", context.getStepContext().getStepExecution().getJobExecution().getJobInstance().getJobName());
    }
}
