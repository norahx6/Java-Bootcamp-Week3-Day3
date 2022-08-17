package com.example.day8hw1.repository;


import com.example.day8hw1.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Integer> {

    Teacher findTeacherById(Integer id);

    List<Teacher> findBySalary(Integer salary);


}
