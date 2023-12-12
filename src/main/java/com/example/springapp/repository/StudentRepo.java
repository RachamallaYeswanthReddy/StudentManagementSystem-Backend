package com.example.springapp.repository;

import com.example.springapp.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.springframework.data.jpa.repository.Query;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer> {
    @Query(value = "SELECT COALESCE(MAX(id), 0) + 1 FROM Student")
    int getNextSeriesId();
}
