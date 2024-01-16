package com.springboot.lesson2.controllers;

import com.springboot.lesson2.domain.Student;
import com.springboot.lesson2.persistence.StrudenRepository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {


    StudentRepository studentRepository;

    public StudentController(@Autowired StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/{id}")
    public Student getById(@PathVariable int id) {
        return studentRepository.getById(id).orElseThrow(ResourceNotFoundException::new);
    }

    @GetMapping("/all")
    public List<Student> getAll() {
        return studentRepository.getAll();
    }

    @GetMapping("/search")
    public List<Student> search(@RequestParam String name) {
        return studentRepository.getAll().stream().filter(student -> student.getName().contains(name)).toList();
    }

    @PostMapping
    public Student create(@RequestBody Student student) {
        return studentRepository.add(student);
    }

    @DeleteMapping("{id}")
    public Student delete(@PathVariable int id) {
        return studentRepository.deleteById(id).orElseThrow(ResourceNotFoundException::new);
    }


}
