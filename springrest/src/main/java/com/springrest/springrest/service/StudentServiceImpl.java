package com.springrest.springrest.service;


import com.springrest.springrest.dto.StudentDto;
import com.springrest.springrest.exception.StudentNotFoundException;
import com.springrest.springrest.mapper.StudentMapper;
import com.springrest.springrest.model.StudentModel;
import com.springrest.springrest.repository.StudentRepo;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@EnableCaching
public class StudentServiceImpl implements StudentService {

    private final StudentRepo exampleRepo;
    @Autowired
    public StudentServiceImpl(StudentRepo exampleRepo) {
        this.exampleRepo = exampleRepo;
    }

    //perform action after bean creation
    @PostConstruct
    public void init() {
        System.out.println("ExampleServiceImpl init");
    }
    //perform action before bean is destroyed
    @PreDestroy
    public void destroy() {
        System.out.println("ExampleServiceImpl destroy");
    }

    @Override
    @Transactional(readOnly = true)
    public List<StudentDto> getStudents() {
        return exampleRepo.findAll()
                .stream()
                .map(StudentMapper.INSTANCE::convertExampleEntityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<StudentDto>runCustomQuery(){
        return exampleRepo.getStudentsByName("abi")
                .stream()
                .map((StudentMapper.INSTANCE::convertExampleEntityToDto))
                .collect(Collectors.toList());
    }

    @Override
    public StudentDto runCustomQueryGetById(int id){
        return StudentMapper.INSTANCE.convertExampleEntityToDto(exampleRepo.getStudentsById(id));
    }

    @Override
    @Transactional(readOnly = true)
    @Cacheable(key = "#id", value = "students")
    public StudentDto getStudent(int id) {
        if(exampleRepo.findById(id).isEmpty())
            throw new StudentNotFoundException("Student with id " + id + " not found");
        StudentModel student = exampleRepo.findById(id).get();
        return StudentMapper.INSTANCE.convertExampleEntityToDto(student);
    }

    @Override
    @Transactional
    public void addStudent(StudentDto student) {
        exampleRepo.save(StudentMapper.INSTANCE.convertDtoToExampleEntity(student));
    }

    @Override
    @Transactional
    public StudentDto updateStudent(int id) {
        if(exampleRepo.findById(id).isEmpty())
            throw new StudentNotFoundException("Student with id " + id + " not found");
        StudentModel student = exampleRepo.findById(id).get();
        student.setName("honitus2.0");
        student.setRoll("200000");
        student.setCourse("Cough Remedy");
        exampleRepo.save(student);

        return StudentMapper.INSTANCE.convertExampleEntityToDto(student);
    }

    @Override
    @Transactional
    @CacheEvict(value = "students", key = "#id")
    public String deleteStudent(int id) {
        if(exampleRepo.findById(id).isEmpty())
            throw new StudentNotFoundException("Student with id " + id + " not found");
        StudentModel student = exampleRepo.findById(id).get();
        exampleRepo.delete(student);
        return "Student deleted, id=" + id;
    }


}
