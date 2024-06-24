package com.hendisantika.springbootwebfluxreactivemongoexample.controller;

import com.hendisantika.springbootwebfluxreactivemongoexample.model.Person;
import com.hendisantika.springbootwebfluxreactivemongoexample.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

/**
 * Created by IntelliJ IDEA.
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 9/7/17
 * Time: 9:45 PM
 * To change this template use File | Settings | File Templates.
 */

@RestController
@RequestMapping("/person")
@RequiredArgsConstructor
public class PersonController {
    private final PersonRepository personRepository;

    @GetMapping
    public Flux<Person> index() {
        return personRepository.findAll();
    }
}
