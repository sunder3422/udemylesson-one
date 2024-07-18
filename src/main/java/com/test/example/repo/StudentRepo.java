package com.test.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.example.entity.Student;

public interface StudentRepo extends JpaRepository<Student,String>{

}
