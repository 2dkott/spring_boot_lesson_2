package com.springboot.lesson2.controllers;

import com.springboot.lesson2.domain.Student;
import com.springboot.lesson2.persistence.StrudenRepository.GroupRepository;
import com.springboot.lesson2.persistence.StrudenRepository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/group")
public class GroupController {

    GroupRepository groupRepository;
    StudentRepository studentRepository;

    public GroupController(@Autowired GroupRepository groupRepository, @Autowired StudentRepository studentRepository) {
        this.groupRepository = groupRepository;
        this.studentRepository = studentRepository;
    }

    @GetMapping("/{groupName}/student")
    public List<Student> getStudents(@PathVariable String groupName) {
        return studentRepository.getAll().stream().filter(student -> student.getGroupName().equals(groupName)).toList();
    }
}
