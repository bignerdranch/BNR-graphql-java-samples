package com.bnr.graphql.resolver;

import com.bnr.graphql.data.Cow;
import com.bnr.graphql.data.Nerd;
import com.bnr.graphql.repository.BNRRepository;
import graphql.kickstart.tools.GraphQLQueryResolver;

import java.util.List;

public class Query implements GraphQLQueryResolver {
    private final BNRRepository repository;

    public Query(BNRRepository repository) {
        this.repository = repository;
    }

    public Cow cow(String id) {
        return repository.getCow(id);
    }

    public List<Cow> cows() {
        return repository.getCows();
    }

    public Nerd nerd(String id) {
        return repository.getNerd(id);
    }

    public List<Nerd> nerds() {
        return repository.getNerds();
    }
}
