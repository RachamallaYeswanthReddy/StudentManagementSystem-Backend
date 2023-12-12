package com.example.springapp.service;

import java.util.List;
import java.util.Optional;

import com.example.springapp.model.Student;
import com.example.springapp.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Studentservice {

    @Autowired
    private StudentRepo repo;

    public boolean addStudent(Student student) {
        if (student.getId() == 0){
            student.setId(repo.getNextSeriesId());
        }
        repo.save(student);
        return true;
    }
    


    public List <Student> getAllStudents()
    {
        return repo.findAll();
    }

    public Optional<Student> getById(int id)
    {
        return repo.findById(id);

    }

    public boolean deleteById(int id)
{
    if (repo.existsById(id))
    {
        repo.deleteById(id);
        return true;
    }
    else
    {
        return false;
    }
}
}
