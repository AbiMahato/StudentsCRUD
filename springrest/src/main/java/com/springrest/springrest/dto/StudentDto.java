package com.springrest.springrest.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

//@Data
public class StudentDto {
    @NotEmpty
    private String name;

    @NotEmpty
    @Size(max = 6 , min = 2 , message = "roll must be between 2-6 characters")
    private String roll;

    @NotEmpty
    private String course;

    public StudentDto(String name, String roll, String course) {
        this.name = name;
        this.roll = roll;
        this.course = course;
    }
    public StudentDto() {}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRoll() {
        return roll;
    }

    public void setRoll(String roll) {
        this.roll = roll;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }


}
