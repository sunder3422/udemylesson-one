package com.test.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.test.example.entity.Student;
import com.test.example.service.StudentService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;




@Controller
@RequestMapping
public class StudentController {

    @Autowired
    private StudentService studentService;

    @GetMapping("/allstudents")
    public String getAllStudents(Model model) {
        List<Student> students= studentService.getAllStudents();
        System.out.println(students);
        model.addAttribute("allstudents", students);
        return "Students";
    }
    @GetMapping("/")
    public String getHomepage(@ModelAttribute("student") Student student,Model model) {
        model.addAttribute("student", new Student());
        return "Index";
    }
    @GetMapping("/path")
    public String getMethodName(@RequestParam String param) {
        return new String("test");
    }
    
    @PostMapping("/updateuser")
    public RedirectView  postMethodName(@ModelAttribute("student") Student student, Model model) {
        model.addAttribute("student", student);

        System.out.println(student);
        studentService.addusers(student);
        return new RedirectView("/allstudents");
    }
    
    
    
}
