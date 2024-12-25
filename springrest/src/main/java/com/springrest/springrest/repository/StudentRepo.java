package com.springrest.springrest.repository;

import com.springrest.springrest.model.StudentModel;
import jakarta.persistence.QueryHint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepo extends JpaRepository<StudentModel, Integer> {
    @Query("SELECT u from StudentModel u where u.name=:n")
    @QueryHints({
            @QueryHint(name = "org.hibernate.readOnly",value = "true"),
            @QueryHint(name = "org.hibernate.fetchSize",value = "2"),
            @QueryHint(name = "org.hibernate.cacheable",value = "true"),
            @QueryHint(name = "javax.persistence.cache.retrieveMode",value = "USE"),
            @QueryHint(name = "javax.persistence.cache.storeMode",value = "USE"),

    })
    List<StudentModel> getStudentsByName(@Param("n") String name);


    @Query("SELECT u from StudentModel u where u.id=:i")
    @QueryHints({
            @QueryHint(name = "org.hibernate.readOnly",value = "true"),
            @QueryHint(name = "org.hibernate.fetchSize",value = "2"),
            @QueryHint(name = "org.hibernate.cacheable",value = "true"),
            @QueryHint(name = "javax.persistence.cache.retrieveMode",value = "USE"),
            @QueryHint(name = "javax.persistence.cache.storeMode",value = "USE"),

    })
    StudentModel getStudentsById(@Param("i") int i);
}
