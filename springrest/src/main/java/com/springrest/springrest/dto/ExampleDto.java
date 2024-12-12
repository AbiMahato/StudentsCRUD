package com.springrest.springrest.dto;

import lombok.Data;

//@Data
public class ExampleDto {
    private String name;
    private String roll;
    private String course;

    public ExampleDto(String name, String roll, String course) {
        this.name = name;
        this.roll = roll;
        this.course = course;
    }
    public ExampleDto() {}

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
