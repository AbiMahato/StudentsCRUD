package com.springrest.springrest.controller;

import com.springrest.springrest.dto.ExampleDto;
import com.springrest.springrest.service.ExampleService;
import com.springrest.springrest.service.ExampleServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MyController {

    private final ExampleService exampleService;
    @Autowired
    public MyController(ExampleService exampleService) {
        this.exampleService = exampleService;
    }

    private Logger logger = LoggerFactory.getLogger(MyController.class);

    @GetMapping("/students")
    public List<ExampleDto> getStudents() {
        logger.info("getStudents called");
        return  exampleService.getStudents();
    }
    @GetMapping("/students/{id}")
    public ExampleDto getStudent(@PathVariable int id) {
        logger.info("getStudent called");
        return exampleService.getStudent(id);
    }

    @PostMapping("/students/add")
    @ResponseStatus(code = HttpStatus.CREATED)
    public void addStudent(@RequestBody ExampleDto student) {
        logger.info("addStudent called");
        exampleService.addStudent(student);
    }

    @PutMapping("/students/update/{id}")
    public ExampleDto updateStudent(@PathVariable int id ){
        logger.info("updateStudent called");
        return exampleService.updateStudent(id);
    }

    @DeleteMapping("students/delete/{id}")
    public String deleteStudent(@PathVariable int id) {
        logger.info("deleteStudent called");
        return exampleService.deleteStudent(id) ;
    }
}
