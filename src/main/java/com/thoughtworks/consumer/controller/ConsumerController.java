package com.thoughtworks.consumer.controller;

import com.thoughtworks.consumer.model.Consumer;
import com.thoughtworks.consumer.service.ConsumerData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/consumers")
public class ConsumerController {

    @Autowired
    private ConsumerData consumerData;

    @GetMapping
    public ResponseEntity<List<Consumer>> allConsumers(){
        List<Consumer> consumers = consumerData.getBYAllConsumer();
        return new ResponseEntity<>(consumers, HttpStatus.OK);

    }
}
