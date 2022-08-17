package com.example.day8hw1.repository;

import com.example.day8hw1.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository <Student,Integer> {

    Student findStudentById(Integer id);
    Student findStudentByName(String name);

    List<Student>findByMajor(String major);

    List<Student>findByAgeGreaterThanEqual(Integer age);


}
