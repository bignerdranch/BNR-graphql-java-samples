package com.bnr.graphql.repository;

import com.bnr.graphql.data.Cow;
import com.bnr.graphql.data.Nerd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BNRRepository {
    private final Map<String, Cow> cows;
    private final Map<String, Nerd> nerds;

    public BNRRepository() {
        cows = new HashMap<>();
        nerds = new HashMap<>();

        Cow cow1 = new Cow("1", "Black", 3);
        cows.put(cow1.getId(), cow1);
        Cow cow2 = new Cow("2", "Black", 9);
        cows.put(cow2.getId(), cow2);
        Cow cow3 = new Cow("3", "Brown", 2);
        cows.put(cow3.getId(), cow3);
        Cow cow4 = new Cow("4", "White", 5);
        cows.put(cow4.getId(), cow4);
        Cow cow5 = new Cow("5", "Purple", 7);
        cows.put(cow5.getId(), cow5);

        nerds.put("1", new Nerd("1", List.of("Java", "GraphQL"), "Luke Skywalker", 60, List.of(cow4, cow5)));
        nerds.put("2", new Nerd("2", List.of("ReactJS", "Kotlin"), "Smokey Bear", 112, List.of(cow1)));
        nerds.put("3", new Nerd("3", List.of("HTML"), "Mickey Mouse", 98, List.of(cow2, cow3)));
    }

    public Cow getCow(String id) {
        return cows.get(id);
    }

    public List<Cow> getCows() {
        return new ArrayList<Cow>(cows.values());
    }

    public void addCow(Cow cow) {
        cows.put(cow.getId(), cow);
    }

    public Cow banishCow(String id) {
        return cows.remove(id);
    }

    public Nerd getNerd(String id) {
        return nerds.get(id);
    }

    public List<Nerd> getNerds() {
        return new ArrayList<Nerd>(nerds.values());
    }
}
