package com.graphqlspringboot.samplegraphqlserver;

import com.graphqlspringboot.samplegraphqlserver.exception.GraphQLErrorAdapter;
import com.graphqlspringboot.samplegraphqlserver.resolver.BookResolver;
import com.graphqlspringboot.samplegraphqlserver.resolver.Mutation;
import com.graphqlspringboot.samplegraphqlserver.resolver.Query;
import com.graphqlspringboot.samplegraphqlserver.service.InitDataService;
import graphql.ExceptionWhileDataFetching;
import graphql.GraphQLError;
import graphql.servlet.GraphQLErrorHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Configuration
public class ApplicationConfiguration {
    @Autowired
    private InitDataService initDataService;
    @Bean
    public BookResolver authorResolver() {
        return new BookResolver();
    }

    @Bean
    public Query query() {
        return new Query();
    }

    @Bean
    public Mutation mutation() {
        return new Mutation();
    }

    @Bean
    public CommandLineRunner initData() {
        return (args) -> {
            initDataService.init();
        };
    }

    @Bean
    public GraphQLErrorHandler errorHandler() {
        return new GraphQLErrorHandler() {
            @Override
            public List<GraphQLError> processErrors(List<GraphQLError> errors) {
                List<GraphQLError> clientErrors = errors.stream()
                        .filter(this::isClientError)
                        .collect(Collectors.toList());

                List<GraphQLError> serverErrors = errors.stream()
                        .filter(e -> !isClientError(e))
                        .map(GraphQLErrorAdapter::new)
                        .collect(Collectors.toList());

                List<GraphQLError> e = new ArrayList<>();
                e.addAll(clientErrors);
                e.addAll(serverErrors);
                return e;
            }

            protected boolean isClientError(GraphQLError error) {
                return !(error instanceof ExceptionWhileDataFetching || error instanceof Throwable);
            }
        };
    }
}
