package com.hendisantika.springbootwebfluxreactivemongoexample.controller;

import com.hendisantika.springbootwebfluxreactivemongoexample.model.Person;
import com.hendisantika.springbootwebfluxreactivemongoexample.repository.PersonRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.web.reactive.function.server.RequestPredicates;
import org.springframework.web.reactive.function.server.RouterFunction;

import static org.springframework.web.reactive.function.server.RequestPredicates.method;
import static org.springframework.web.reactive.function.server.RequestPredicates.path;
import static org.springframework.web.reactive.function.server.RouterFunctions.nest;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

/**
 * Created by IntelliJ IDEA.
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 9/7/17
 * Time: 9:43 PM
 * To change this template use File | Settings | File Templates.
 */

@Configuration
public class RoutesConfiguration {
    @Bean
    RouterFunction<?> routes(PersonRepository personRespository) {
        return nest(path("/person"),

                route(RequestPredicates.GET("/{id}"),
                        request -> ok().body(personRespository.findById(request.pathVariable("id")), Person.class))

                        .andRoute(method(HttpMethod.POST),
                                request -> {
                                    personRespository.insert(request.bodyToMono(Person.class)).subscribe();
                                    return ok().build();
                                })
        );
    }
}
