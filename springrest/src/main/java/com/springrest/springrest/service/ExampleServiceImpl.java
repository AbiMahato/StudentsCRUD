package com.springrest.springrest.service;


import com.springrest.springrest.dto.ExampleDto;
import com.springrest.springrest.exception.StudentNotFoundException;
import com.springrest.springrest.mapper.ExampleMapper;
import com.springrest.springrest.model.ExampleModel;
import com.springrest.springrest.repository.ExampleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ExampleServiceImpl implements ExampleService {

    private final ExampleRepo exampleRepo;
    @Autowired
    public ExampleServiceImpl(ExampleRepo exampleRepo) {
        this.exampleRepo = exampleRepo;
    }

    @Override
    public List<ExampleDto> getStudents() {
        return exampleRepo.findAll()
                .stream()
                .map(ExampleMapper.INSTANCE::convertExampleEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public ExampleDto getStudent(int id) {
        if(exampleRepo.findById(id).isEmpty())
            throw new StudentNotFoundException("Student with id " + id + " not found");
        ExampleModel student = exampleRepo.findById(id).get();
        return ExampleMapper.INSTANCE.convertExampleEntityToDto(student);
    }

    @Override
    public void addStudent(ExampleDto student) {
        exampleRepo.save(ExampleMapper.INSTANCE.convertDtoToExampleEntity(student));
    }

    @Override
    public ExampleDto updateStudent(int id) {
        if(exampleRepo.findById(id).isEmpty())
            throw new StudentNotFoundException("Student with id " + id + " not found");
        ExampleModel student = exampleRepo.findById(id).get();
        student.setName("honitus2.0");
        student.setRoll("200000");
        student.setCourse("Cough Remedy");
        exampleRepo.save(student);

        return ExampleMapper.INSTANCE.convertExampleEntityToDto(student);
    }

    @Override
    public String deleteStudent(int id) {
        if(exampleRepo.findById(id).isEmpty())
            throw new StudentNotFoundException("Student with id " + id + " not found");
        ExampleModel student = exampleRepo.findById(id).get();
        exampleRepo.delete(student);
        return "Student deleted, id=" + id;
    }

//    public ExampleDto convertExampleEntityToDto(ExampleModel student) {
//        ExampleDto dto = new ExampleDto();
//        dto.setCourse(student.getCourse());
//        dto.setRoll(student.getRoll());
//        dto.setName(student.getName());
//        return dto;
//    }
//    public ExampleModel convertDtoToExampleEntity(ExampleDto student) {
//        ExampleModel model = new ExampleModel();
//        model.setCourse(student.getCourse());
//        model.setRoll(student.getRoll());
//        model.setName(student.getName());
//        return model;
//    }
}
