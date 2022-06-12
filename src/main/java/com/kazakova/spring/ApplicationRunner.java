package com.kazakova.spring;

import com.kazakova.spring.database.pool.ConnectionPool;
import com.kazakova.spring.database.repository.CompanyRepository;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationRunner {

    public static void main(String[] args) {
        var context = new ClassPathXmlApplicationContext("application.xml");
        System.out.println(context.getBean("pool1", ConnectionPool.class));
        System.out.println(context.getBean("companyRepository", CompanyRepository.class));
    }
}
