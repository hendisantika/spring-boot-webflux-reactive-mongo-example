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

    /**
     * Derived query selecting by {@code lastname}.
     *
     * @param lastname
     * @return
     */
    Flux<Person> findByLastname(String lastname);

    /**
     * String query selecting one entity.
     *
     * @param lastname
     * @return
     */
    @Query("{ 'firstname': ?0, 'lastname': ?1}")
    Mono<Person> findByFirstnameAndLastname(String firstname, String lastname);

    /**
     * Derived query selecting by {@code lastname}. {@code lastname} uses deferred resolution that does not require
     * blocking to obtain the parameter value.
     *
     * @param lastname
     * @return
     */
    Flux<Person> findByLastname(Mono<String> lastname);

    /**
     * Derived query selecting by {@code firstname} and {@code lastname}. {@code firstname} uses deferred resolution that
     * does not require blocking to obtain the parameter value.
     *
     * @param firstname
     * @param lastname
     * @return
     */
    Mono<Person> findByFirstnameAndLastname(Mono<String> firstname, String lastname);

}
