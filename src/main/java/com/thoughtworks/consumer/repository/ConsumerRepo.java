package com.thoughtworks.consumer.repository;

import com.thoughtworks.consumer.model.Consumer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsumerRepo extends JpaRepository<Consumer, Long> {
}
