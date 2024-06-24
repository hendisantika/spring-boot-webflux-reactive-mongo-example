package com.hendisantika.springbootwebfluxreactivemongoexample.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by IntelliJ IDEA.
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 9/7/17
 * Time: 9:34 PM
 * To change this template use File | Settings | File Templates.
 */

@Document
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Person {
    @Id
    private String id;
    private String firstName;
    private String lastName;
    private int age;
}
