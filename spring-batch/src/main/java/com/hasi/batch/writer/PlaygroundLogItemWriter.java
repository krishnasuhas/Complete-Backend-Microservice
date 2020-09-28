package com.hasi.batch.writer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Slf4j
public class PlaygroundLogItemWriter implements ItemWriter<String> {

    @Override
    public void write(List<? extends String> list) {
        list.forEach(log::info);
    }
}
