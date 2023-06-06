package com.wileyedge.studentwebservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wileyedge.studentwebservice.model.Student;

@Repository(value="jparepos")
public interface UserJpaRepository extends IDao, JpaRepository<Student, Integer> {

}
