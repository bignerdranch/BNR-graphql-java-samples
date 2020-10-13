package com.bnr.graphql.resolver;

import com.bnr.graphql.data.Cow;
import com.bnr.graphql.repository.BNRRepository;
import graphql.kickstart.tools.GraphQLMutationResolver;

import java.util.UUID;

public class Mutation implements GraphQLMutationResolver {
    private final BNRRepository repository;

    public Mutation(BNRRepository repository) {
        this.repository = repository;
    }

    public Cow addCow(String color, int age) {
        Cow newCow = new Cow(UUID.randomUUID().toString(), color, age);
        repository.addCow(newCow);
        return newCow;
    }

    public Cow banishCow(String id) {
        return repository.banishCow(id);
    }
}
