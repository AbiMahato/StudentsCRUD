package com.springrest.springrest.controller;

import com.springrest.springrest.dto.StudentDto;
import com.springrest.springrest.service.StudentService;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@OpenAPIDefinition(info = @Info(title = "Students APIs", version = "2.0"))
public class StudentController {

    private final StudentService exampleService;
    @Autowired
    public StudentController(StudentService exampleService) {
        this.exampleService = exampleService;
    }

    private Logger logger = LoggerFactory.getLogger(StudentController.class);

    @GetMapping
    public List<StudentDto> getStudents() {
        logger.info("getStudents called");
        return  exampleService.getStudents();
    }

    @GetMapping("/custom/{id}")
    public StudentDto runCustomQueryGetById(@PathVariable int id) {
        return exampleService.runCustomQueryGetById(id);
    }
    @GetMapping("/{id}")
    public StudentDto getStudent(@PathVariable int id) {
        logger.info("getStudent called");
        return exampleService.getStudent(id);
    }

    @PostMapping("/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addStudent(@Valid @RequestBody StudentDto student) {
        logger.info("addStudent called");
        exampleService.addStudent(student);
    }

    @PutMapping("/update/{id}")
    public StudentDto updateStudent(@PathVariable int id ){
        logger.info("updateStudent called");
        return exampleService.updateStudent(id);
    }

    @DeleteMapping("delete/{id}")
    public String deleteStudent(@PathVariable int id) {
        logger.info("deleteStudent called");
        return exampleService.deleteStudent(id) ;
    }

    @GetMapping("/custom")
    public List<StudentDto> runCustomQuery() {
        return exampleService.runCustomQuery();
    }
}
