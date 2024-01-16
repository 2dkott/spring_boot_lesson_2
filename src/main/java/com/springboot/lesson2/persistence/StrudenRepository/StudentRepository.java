package com.springboot.lesson2.persistence.StrudenRepository;

import com.springboot.lesson2.domain.Student;

import java.util.List;
import java.util.Optional;

public interface StudentRepository {

    Student add(Student student);

    List<Student> getAll();

    Optional<Student> getById(int id);

    Optional<Student> deleteById(int id);
}
