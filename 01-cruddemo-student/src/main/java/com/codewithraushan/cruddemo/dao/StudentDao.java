package com.codewithraushan.cruddemo.dao;

import com.codewithraushan.cruddemo.entity.Student;

import java.util.List;

public interface StudentDao {

    void save(Student theStudent);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String theLastName);
}
