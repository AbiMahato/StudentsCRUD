package com.springrest.springrest.model;

import jakarta.persistence.*;

import lombok.Data;

//@Data
@Entity
@Table(name="students")
public class ExampleModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String roll;
    private String course;



    public ExampleModel(int id, String name, String roll, String course) {
        this.id = id;
        this.name = name;
        this.roll = roll;
        this.course = course;
    }
    public ExampleModel() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
