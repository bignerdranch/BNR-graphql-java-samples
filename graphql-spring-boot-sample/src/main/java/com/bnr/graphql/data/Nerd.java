package com.bnr.graphql.data;

import java.util.List;

public class Nerd {
    private final String id;
    private final List<String> skills;
    private final String name;
    private int age;
    private List<Cow> cattle;

    public Nerd(String id, List<String> skills, String name, int age, List<Cow> cows) {
        this.id = id;
        this.skills = skills;
        this.name = name;
        this.age = age;
        this.cattle = cows;
    }

    public String getId() {
        return id;
    }

    public List<String> getSkills() {
        return skills;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public List<Cow> getCattle() {
        return cattle;
    }
}
