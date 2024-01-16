package com.springboot.lesson2.persistence.StrudenRepository;

import com.springboot.lesson2.domain.Student;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Component
public class InMemoryStudentRepository implements StudentRepository{

    List<Student> students = new ArrayList<>();

    public InMemoryStudentRepository() {
        generate();
    }

    @Override
    public Student add(Student student) {
        students.add(student);
        return student;
    }

    @Override
    public List<Student> getAll() {
        return List.copyOf(students);
    }

    @Override
    public Optional<Student> getById(int id) {
        return students.stream().filter(student -> student.getId()==id).findAny();
    }

    @Override
    public Optional<Student> deleteById(int id) {
        Optional<Student> deleteStudent  = students.stream().filter(student -> student.getId()==id).findAny();
        deleteStudent.ifPresent(student -> students.remove(student));
        return deleteStudent;
    }

    private void generate() {
        for (int i = 0; i<20; i++) {
            String groupName = String.format("Group_%s", new Random().nextInt(0, 5));
            Student student = new Student(String.format("Student%s", i), groupName);
            students.add(student);
        }
    }



}
