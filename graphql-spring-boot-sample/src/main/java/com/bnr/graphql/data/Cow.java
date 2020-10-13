package com.bnr.graphql.data;

public class Cow {
    private final String id;
    private final String color;
    private final int age;

    public Cow(String id, String color, int age) {
        this.id = id;
        this.color = color;
        this.age = age;
    }

    public String getId() {
        return id;
    }

    public String getColor() {
        return color;
    }

    public int getAge() {
        return age;
    }
}
