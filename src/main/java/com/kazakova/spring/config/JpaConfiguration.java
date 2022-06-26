package com.kazakova.spring.config;

import com.kazakova.spring.config.condition.JpaCondition;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
@Conditional(JpaCondition.class)
public class JpaConfiguration {

    @PostConstruct
    public void init() {
        System.out.println("Jpa configuration is enabled");
    }
}
