package com.example.day8hw1.service;

import com.example.day8hw1.model.Student;
import com.example.day8hw1.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentServise {

    private final StudentRepository studentRepository;

    // 1 getting
    public List<Student> getstudent() {
        return studentRepository.findAll();
    }

    // 2 adding
    public void addstudent(Student student) {
        studentRepository.save(student);
    }

    // 3 deleting
    public void updatestudent(Student student, Integer id) {
        Student oldstudent = studentRepository.getById(id);
        oldstudent.setName(student.getName());
        oldstudent.setAge(student.getAge());
        oldstudent.setMajor(student.getMajor());
        studentRepository.save(oldstudent);
    }

    // 4 deleting
    public void deletestudent(Integer id) {
        Student mystudent = studentRepository.getById(id);
        studentRepository.delete(mystudent);
    }

    // 5 find student by id
    public Student getStudentById(Integer id){

        return studentRepository.findStudentById(id);
    }

    // 6 find student by name
    public Student getStudentByName(String name){

        return  studentRepository.findStudentByName(name);
    }

    // 7 find student by major
    public List<Student>findByMajor(String major){

        return studentRepository.findByMajor(major);
    }

    // 8 find student by age
    public List<Student>findByAgeGreaterThan(Integer age){

        return studentRepository.findByAgeGreaterThanEqual(age);

    }

}// end
