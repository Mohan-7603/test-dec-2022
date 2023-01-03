package com.example.springboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.Entity;


@SpringBootApplication
@ComponentScan({"com.example.springboot"})
@EntityScan("com.example.springboot")
@EnableJpaRepositories("com.example.springboot")
public class SpringDataJpaApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataJpaApplication.class,args);

    }
    @Bean
    public CommandLineRunner run(EmployeeRepository repository){
        return(args->{
            insertJavaAdvocate(repository);
            System.out.println(repository.findAll());
        });

    }

    private void insertJavaAdvocate(EmployeeRepository repository) {
        repository.save(new Employee("Mohan", "Raj"));
    }

}
