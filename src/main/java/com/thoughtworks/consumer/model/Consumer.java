package com.thoughtworks.consumer.model;

import lombok.Data;

import javax.persistence.*;


@Data
@Entity
@Table(name = "consumer")
public class Consumer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true,name = "username")
    private String userName;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "address")
    private String address;

    @Column(name = "companyname")
    private String companyName;

    @Column(name = "jobtype")
    private String jobType;

    @Column(name = "salary")
    private String salary;

}
