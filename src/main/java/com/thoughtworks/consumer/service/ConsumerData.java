package com.thoughtworks.consumer.service;


import com.thoughtworks.consumer.dto.ConsumerDto;
import com.thoughtworks.consumer.model.Consumer;
import com.thoughtworks.consumer.repository.ConsumerRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ConsumerData {

    @Autowired
    private ConsumerRepo consumerRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private  RabbitMQConsumer rabbitMQConsumer;

    public List<Consumer> getBYAllConsumer(){
        List<Consumer> consumers = consumerRepo.findAll();
        return consumers;
    }

}
