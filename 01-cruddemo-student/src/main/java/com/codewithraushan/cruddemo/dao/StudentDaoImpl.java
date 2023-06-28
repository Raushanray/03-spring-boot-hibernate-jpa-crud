package com.codewithraushan.cruddemo.dao;

import com.codewithraushan.cruddemo.entity.Student;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class StudentDaoImpl implements StudentDao{

    //define field for entity manager

    private EntityManager entityManager;

    //inject entity manager using constructor injection


    @Autowired
    public StudentDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //implement save method
    @Override
    @Transactional
    public void save(Student theStudent) {

        entityManager.persist(theStudent);
    }
}
