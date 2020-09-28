package com.hasi.batch.flow;

import com.hasi.batch.step.PlaygroundStep;
import org.springframework.batch.core.job.builder.FlowBuilder;
import org.springframework.batch.core.job.flow.Flow;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PlaygroundFlow {

    @Autowired
    PlaygroundStep playgroundStep;

    public Flow flow1() {
        FlowBuilder<Flow> flowBuilder = new FlowBuilder<>("flow1");
        return flowBuilder.start(playgroundStep.dummyStep1())
                .end();
    }

    public Flow flow2() {
        FlowBuilder<Flow> flowBuilder = new FlowBuilder<>("flow2");
        return flowBuilder.start(playgroundStep.dummyStep2())
                .end();
    }
}
