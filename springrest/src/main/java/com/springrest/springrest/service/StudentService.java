package com.springrest.springrest.service;

import com.springrest.springrest.dto.StudentDto;

import java.util.List;

public interface StudentService {
    List<StudentDto> getStudents();
    StudentDto getStudent(int id);
    void addStudent(StudentDto student);
    StudentDto updateStudent(int id);
    String deleteStudent(int id);
    List<StudentDto>runCustomQuery();
    StudentDto runCustomQueryGetById(int id);
}
