package com.bnr.graphql;

import com.bnr.graphql.data.Cow;
import com.bnr.graphql.repository.BNRRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.graphql.spring.boot.test.GraphQLResponse;
import com.graphql.spring.boot.test.GraphQLTest;
import com.graphql.spring.boot.test.GraphQLTestTemplate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
@GraphQLTest
public class GraphQLApplicationIT {
    @Autowired
    private GraphQLTestTemplate graphQLTestTemplate;

    @MockBean
    private BNRRepository mockRepository;

    @Test
    public void getCows() throws IOException {
        when(mockRepository.getCows()).thenReturn(new BNRRepository().getCows());

        GraphQLResponse response = graphQLTestTemplate.postForResource("graphql/query/get-cows.graphql");
        assertNotNull(response);
        assertTrue(response.isOk());

        verify(mockRepository).getCows();
        assertEquals("1", response.get("$.data.cows[0].id"));
        assertEquals("Black", response.get("$.data.cows[0].color"));
        assertEquals("5", response.get("$.data.cows.length()"));
    }

    @Test
    public void getNerd() throws IOException {
        when(mockRepository.getNerd(anyString())).thenReturn(new BNRRepository().getNerds().get(0));

        GraphQLResponse response = graphQLTestTemplate.postForResource("graphql/query/get-nerd-1.graphql");
        assertNotNull(response);
        assertTrue(response.isOk());

        verify(mockRepository).getNerd("1");
        assertEquals("Luke Skywalker", response.get("$.data.nerd.name"));
        assertEquals("60", response.get("$.data.nerd.age"));
        assertEquals("4", response.get("$.data.nerd.cattle[0].id"));
    }

    @Test
    public void addAndBanishCow() throws IOException {
        GraphQLResponse createdCowResponse = graphQLTestTemplate.postForResource("graphql/mutation/create-cow.graphql");

        assertNotNull(createdCowResponse);
        assertTrue(createdCowResponse.isOk());
        verify(mockRepository).addCow(any(Cow.class));

        String createdCowId = createdCowResponse.get("$.data.addCow.id");

        ObjectNode variables = new ObjectMapper().createObjectNode();
        variables.put("cowId", createdCowId);
        GraphQLResponse banishedCowResponse = graphQLTestTemplate.perform("graphql/mutation/banish-cow.graphql", variables);

        assertNotNull(banishedCowResponse);
        assertTrue(banishedCowResponse.isOk());
        verify(mockRepository).banishCow(createdCowId);
    }
}
