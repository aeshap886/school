package com.exampl.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.exampl.repository.StudentRepository;

import entity.Student;

@Controller

@RequestMapping("/")
public class StudentController {

    private final StudentRepository studentRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    public StudentController(StudentRepository studentRepository, BCryptPasswordEncoder passwordEncoder) {
        this.studentRepository = studentRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("student", new Student());
        return "register";
    }

    @PostMapping("/register")
    public String registerStudent(@ModelAttribute("student") Student student) {
        student.setPassword(passwordEncoder.encode(student.getPassword()));
        student.setRole("ROLE_USER"); // Optional: assign role
        studentRepository.save(student);
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String showLoginForm() {
        return "login";
    }

    @GetMapping("/student")
    public String studentHome() {
        return "student";
    }
}
