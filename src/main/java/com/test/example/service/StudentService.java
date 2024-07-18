package com.test.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.example.entity.Student;
import com.test.example.repo.StudentRepo;

@Service
public class StudentService {

    @Autowired
    private StudentRepo studentRepo;
    public void addusers(Student student)
    {
        Student studentret=studentRepo.save(student);
        System.out.println(studentret);
    }
    public List<Student> getAllStudents()
    {
        return studentRepo.findAll();
    }
}
