package com.example.demo;

import org.apache.kafka.streams.kstream.GlobalKTable;
import org.springframework.cloud.stream.annotation.Input;

public interface Processor {

    @Input("my-input")
    GlobalKTable<String, String> myTable();

}
