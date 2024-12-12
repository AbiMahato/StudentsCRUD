package com.springrest.springrest.service;

import com.springrest.springrest.dto.ExampleDto;

import java.util.List;

public interface ExampleService {
    List<ExampleDto> getStudents();
    ExampleDto getStudent(int id);
    void addStudent(ExampleDto student);
    ExampleDto updateStudent(int id);
    String deleteStudent(int id);

}
