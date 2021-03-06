package com.epam.simple_service;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FortuneRepo extends CrudRepository<Fortune, Long> {
    List<Fortune> findTopByOrderByIdDesc();
}
