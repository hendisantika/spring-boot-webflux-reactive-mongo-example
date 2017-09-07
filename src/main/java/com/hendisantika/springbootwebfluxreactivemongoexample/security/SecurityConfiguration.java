package com.hendisantika.springbootwebfluxreactivemongoexample.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.userdetails.MapUserDetailsRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsRepository;

import static org.springframework.security.core.userdetails.User.withUsername;

/**
 * Created by IntelliJ IDEA.
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 9/7/17
 * Time: 9:41 PM
 * To change this template use File | Settings | File Templates.
 */

@Configuration
public class SecurityConfiguration {
    @Bean
    UserDetailsRepository userDetailsRepository() {
        UserDetails hendi = withUsername("hendi").password("password").roles("USER").build();
        UserDetails santika = withUsername("santika").password("password").roles("USER", "ADMIN").build();
        return new MapUserDetailsRepository(hendi, santika);
    }
}
