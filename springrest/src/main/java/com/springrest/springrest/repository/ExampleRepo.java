package com.springrest.springrest.repository;

import com.springrest.springrest.model.ExampleModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExampleRepo extends JpaRepository<ExampleModel, Integer> {
}
