package com.bnr.graphql;

import com.bnr.graphql.repository.BNRRepository;
import com.bnr.graphql.resolver.Mutation;
import com.bnr.graphql.resolver.Query;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GraphQLJavaToolsApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphQLJavaToolsApplication.class, args);
	}

	@Bean
	public Query query(BNRRepository repository) {
		return new Query(repository);
	}

	@Bean
	public Mutation mutation(BNRRepository repository) {
		return new Mutation(repository);
	}

	@Bean
	public BNRRepository repository() {
		return new BNRRepository();
	}
}
