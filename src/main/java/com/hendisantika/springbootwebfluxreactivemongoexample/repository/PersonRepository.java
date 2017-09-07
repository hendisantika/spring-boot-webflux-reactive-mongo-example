package com.hendisantika.springbootwebfluxreactivemongoexample.repository;

import com.hendisantika.springbootwebfluxreactivemongoexample.model.Person;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * Created by IntelliJ IDEA.
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 9/7/17
 * Time: 9:39 PM
 * To change this template use File | Settings | File Templates.
 */
public interface PersonRepository extends ReactiveMongoRepository<Person, String>{
    Flux<Person> findByName(String name);

    @Query("{ 'name': ?0, 'age': ?1}")
    Mono<Person> findBynameAndAge(String firstname, int age);

    // Accept parameter inside a reactive type for deferred execution
    Flux<Person> findByAge(Mono<Integer> age);

}
