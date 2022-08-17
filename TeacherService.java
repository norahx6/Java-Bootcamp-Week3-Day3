package com.example.day8hw1.service;

import com.example.day8hw1.model.Teacher;
import com.example.day8hw1.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public List<Teacher> getTeacher(){
        return teacherRepository.findAll();
    }

    public void addTeacher(Teacher teacher){
        teacherRepository.save(teacher);
    }

    public void updateTeacher(Teacher teacher , Integer id){
        Teacher oldteacher = teacherRepository.getById(id);
        oldteacher.setName(teacher.getName());
        oldteacher.setSalary(teacher.getSalary());
        teacherRepository.save(oldteacher);
    }

    public void deleteTeacher(Integer id){
        Teacher myTeacher = teacherRepository.getById(id);
        teacherRepository.delete(myTeacher);
    }


    public Teacher getTeacherById(Integer id) {
        return teacherRepository.findTeacherById(id);
    }


    public List<Teacher> findBySalary(Integer salary) {
        return teacherRepository.findBySalary(salary);
    }


}// end
