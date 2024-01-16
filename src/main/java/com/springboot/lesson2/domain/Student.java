package com.springboot.lesson2.domain;

import lombok.Data;

@Data
public class Student {

    final private String name;
    final private int id;
    final private String groupName;
    static private int tempId = 0;

    public Student(String name, String groupName) {
        this.name = name;
        this.groupName = groupName;
        this.id = tempId++;
    }
}
