package com.thoughtworks.consumer.service;

import com.thoughtworks.consumer.dto.ConsumerDto;
import com.thoughtworks.consumer.model.Consumer;
import com.thoughtworks.consumer.repository.ConsumerRepo;
import org.flywaydb.core.Flyway;
import org.modelmapper.ModelMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConsumer {

    @Autowired
    private ConsumerRepo consumerRepo;
    @Autowired
    private ModelMapper modelMapper;

    @RabbitListener(queues = "abcd.queue")
    public void recievedMessage(ConsumerDto consumerDto) {
        //Consumer consumer = modelMapper.map(consumerDto, Consumer.class);
        Consumer consumer = new Consumer();
        consumer.setFirstName(consumerDto.getFirstName());
        consumer.setAddress(consumerDto.getAddress());
        System.out.println("received message is : " + consumerDto);
        consumerRepo.save(consumer);
    }
}
