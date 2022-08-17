package com.example.day8hw1.controller;


import com.example.day8hw1.Dto.ApiResponse;
import com.example.day8hw1.model.Student;
import com.example.day8hw1.model.Teacher;
import com.example.day8hw1.repository.TeacherRepository;
import com.example.day8hw1.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/Teachers")
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;


    // 1 getting
    @GetMapping("/teacher")
    public ResponseEntity<List> getTeacher(){
        List<Teacher>teacher = teacherService.getTeacher();
        return ResponseEntity.status(200).body(teacher);

    }

    // 2 adding
    @PostMapping("/teacher")
    public ResponseEntity<ApiResponse>addTeacher(@RequestBody @Valid Teacher teacher){
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body(new ApiResponse("teacher added",200));
    }

    // 3 updating
    @PutMapping("/teacher/{id}")
    public ResponseEntity<ApiResponse>updateTeacher(@RequestBody @Valid Teacher teacher , @PathVariable Integer id){
        teacherService.updateTeacher(teacher,id);
        return ResponseEntity.status(200).body(new ApiResponse("teacher updated", 200));
    }

    // 4 deleting
    @DeleteMapping("/user/{id}")
    public ResponseEntity<ApiResponse>deleteTeacher(@PathVariable Integer id){
        teacherService.deleteTeacher(id);
        return ResponseEntity.status(200).body(new ApiResponse("teacher deleted", 200));

    }

    // 5 find student by id
    @PostMapping("/teacher/id")
    public ResponseEntity<Teacher> getTeacherById(@RequestParam Integer id){
        Teacher teacher = teacherService.getTeacherById(id);
        return ResponseEntity.status(200).body(teacher);
    }


    // 6 find student by age
    @PostMapping("/student/age")
    public ResponseEntity<List<Teacher>> getTeacherBySalary(@RequestParam Integer salary){
        List<Teacher> teacher = teacherService.findBySalary(salary);
        return ResponseEntity.status(200).body(teacher);
    }


}// end
