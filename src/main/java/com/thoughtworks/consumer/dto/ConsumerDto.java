package com.thoughtworks.consumer.dto;

import lombok.Data;

import javax.persistence.Column;


@Data
public class ConsumerDto {

    private String userName;

    private String firstName;

    private String lastName;

    private String address;

    private String companyName;

    private String jobType;

    private String salary;

}
