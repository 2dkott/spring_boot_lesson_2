package com.springboot.lesson2.persistence.StrudenRepository;

import com.springboot.lesson2.domain.Group;

import java.util.List;

public interface GroupRepository {
    Group getByName(String name);

    void add(Group group);
    List<Group> getAll();
}
