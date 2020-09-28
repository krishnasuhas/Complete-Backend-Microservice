package com.hasi.batch.reader;

import org.springframework.batch.item.support.ListItemReader;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class PlayGroundListItemReader extends ListItemReader<String> {
    public PlayGroundListItemReader() {
        super(Arrays.asList("one", "two", "three"));
    }
}
