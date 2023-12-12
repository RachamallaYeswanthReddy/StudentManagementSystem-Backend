package com.example.springapp.controller;

import java.util.List;
import java.util.Optional;

import com.example.springapp.model.Student;
import com.example.springapp.service.Studentservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ApiController {

    @Autowired
    private Studentservice service;

    @PostMapping("/addStudent")
    public boolean addStudent(@RequestBody Student student)
    {
        return service.addStudent(student);
    }


    @GetMapping("/deleteById/{id}")
    public boolean deleteById(@PathVariable(name = "id") int id)
    {
        return service.deleteById(id);
    }

    @GetMapping("/getAllStudent")
    public List<Student> getAllStudents(){

        return service.getAllStudents();
    }

    @GetMapping("/getById/{id}")
    public Optional<Student> getById(@PathVariable(name = "id") int id) {
        return service.getById(id);
    }
}
