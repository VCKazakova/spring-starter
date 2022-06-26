package com.kazakova.spring;

import com.kazakova.spring.config.ApplicationConfiguration;
import com.kazakova.spring.database.pool.ConnectionPool;
import com.kazakova.spring.database.repository.CompanyRepository;
import com.kazakova.spring.service.CompanyService;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.Serializable;

public class ApplicationRunner {

    public static void main(String[] args) {
        // проверка принадлежности бина классу и BeanFactoryPostProcessor через Reflection API
        String value = "hello";
        System.out.println(CharSequence.class.isAssignableFrom(value.getClass()));
        System.out.println(BeanFactoryPostProcessor.class.isAssignableFrom(value.getClass()));
        System.out.println(Serializable.class.isAssignableFrom(value.getClass()));

        try (var context = new AnnotationConfigApplicationContext(ApplicationConfiguration.class)) {
            // задаем профили (не использовать такой способ)
//            context.register(ApplicationConfiguration.class);
//            context.getEnvironment().setActiveProfiles("prod", "web");
//            context.refresh();
            //      clazz -> String -> Map<String, Object>
//            var connectionPool = context.getBean("p1", ConnectionPool.class);
//            System.out.println(connectionPool);

            var companyService = context.getBean("companyService", CompanyService.class);
            System.out.println(companyService.findById(1));
        }
    }
}
