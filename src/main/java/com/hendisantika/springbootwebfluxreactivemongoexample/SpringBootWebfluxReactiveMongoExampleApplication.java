package com.hendisantika.springbootwebfluxreactivemongoexample;

import com.hendisantika.springbootwebfluxreactivemongoexample.model.Person;
import com.hendisantika.springbootwebfluxreactivemongoexample.repository.PersonRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;

@SpringBootApplication
public class SpringBootWebfluxReactiveMongoExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootWebfluxReactiveMongoExampleApplication.class, args);
    }


    @Bean
    public CommandLineRunner demo(PersonRepository repository) {
        final Person hendi = new Person("1", "Hendi",  "Santika", 25);
        final Person naruto = new Person("2", "Uzumaki", "Naruto", 25);
        final Person sasuke = new Person("3", "Uchiha",  "Sasuke", 28);
        final Person sakura = new Person("4", "Sakura", "Haruno", 25);
        final Person kakashi = new Person("5", "Hatake", "Kakashi", 45);
        repository.saveAll(Flux.just(hendi, naruto, sasuke, sakura, kakashi)).subscribe();
        repository.findByFirstName("hendi").log().map(Person::getLastName).subscribe(System.out::println);
        repository.findOneByFirstName("hendi").log().map(Person::getId).subscribe(System.out::println);

        return (args) -> {
//			// save students
			repository.save(new Person("1", "Hendi",  "Santika", 25));
			repository.save(new Person("2", "Uzumaki", "Naruto", 25));
			repository.save(new Person("3", "Uchiha",  "Sasuke", 28));
			repository.save(new Person("4", "Sakura", "Haruno", 25));
			repository.save(new Person("5", "Hatake", "Kakashi", 45));
		};
    }

}
