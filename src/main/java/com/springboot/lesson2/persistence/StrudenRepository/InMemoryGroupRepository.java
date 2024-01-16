package com.springboot.lesson2.persistence.StrudenRepository;

import com.springboot.lesson2.domain.Group;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class InMemoryGroupRepository implements GroupRepository {

    private List<Group> groups = new ArrayList<>();

    @PostConstruct
    private void init() {
        generate();
    }


    @Override
    public Group getByName(String name) {
        return groups.stream().filter(group -> group.name().equals(name)).findAny().orElseThrow();
    }

    @Override
    public void add(Group group) {
        groups.add(group);
    }

    @Override
    public List<Group> getAll() {
        return List.copyOf(groups);
    }

    private void generate() {
        for (int i = 0; i<5; i++) {
            groups.add(new Group(String.format("Group_1%s", i)));
        }
    }
}
