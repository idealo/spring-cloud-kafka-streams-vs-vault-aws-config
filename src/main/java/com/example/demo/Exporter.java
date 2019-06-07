package com.example.demo;

import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.stereotype.Component;

@Component
@EnableBinding(Processor.class)
public class Exporter {

}
