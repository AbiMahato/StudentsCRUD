package com.springrest.springrest.model;

import jakarta.persistence.*;

//@Data
@Entity
@Table(name="students")
public class StudentModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String roll;
    private String course;



    public StudentModel(int id, String name, String roll, String course) {
        this.id = id;
        this.name = name;
        this.roll = roll;
        this.course = course;
    }
    public StudentModel() {}

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

    @Override
    public String toString() {
        return "ExampleModel{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", roll='" + roll + '\'' +
                ", course='" + course + '\'' +
                '}';
    }
}
