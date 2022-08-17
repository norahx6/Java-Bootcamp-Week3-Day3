package com.example.day8hw1.controller;

import com.example.day8hw1.Dto.ApiResponse;
import com.example.day8hw1.model.Student;
import com.example.day8hw1.service.StudentServise;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentServise studentServise;

    // 1 getting
    @GetMapping
    public ResponseEntity getstudent(){
        List<Student> students = studentServise.getstudent();
        return ResponseEntity.status(200).body(students);

    }

    // 2 adding
    @PostMapping
    public ResponseEntity<ApiResponse>addstudent(@RequestBody @Valid Student student){
        studentServise.addstudent(student);
        return ResponseEntity.status(200).body(new ApiResponse("student added",200));
    }

    // 3 updating
    @PutMapping("/user/{id}")
    public ResponseEntity<ApiResponse>updatestudent(@RequestBody @Valid Student student , @PathVariable Integer id){
        studentServise.updatestudent(student,id);
        return ResponseEntity.status(200).body(new ApiResponse("student updated", 200));
    }

    // 4 deleting
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ApiResponse>deletestudent(@PathVariable Integer id){
        studentServise.deletestudent(id);
        return ResponseEntity.status(200).body(new ApiResponse("student deleted", 200));

    }

    // 5 find user by id
    @GetMapping("/student/id")
    public ResponseEntity getStudentById(@RequestParam Integer id){
        Student student = studentServise.getStudentById(id);
        return ResponseEntity.status(200).body(student);
    }

    // 6 find student by name
    @GetMapping("/student/name")
    public ResponseEntity getStudentByName(@RequestParam String name){
        Student student = studentServise.getStudentByName(name);
        return ResponseEntity.status(200).body(student);
    }

    // 7 find student by major
    @GetMapping("/student/major")
    public ResponseEntity<List<Student>> getStudentByMajor(@RequestParam String major){
        List<Student> student = studentServise.findByMajor(major);
        return ResponseEntity.status(200).body(student);
    }

    // 8 find student by age
    @GetMapping("/student/age")
    public ResponseEntity<List<Student>> getStudentByAge(@RequestParam Integer age){
        List<Student> student = studentServise.findByAgeGreaterThan(age);
        return ResponseEntity.status(200).body(student);
    }

}// end
