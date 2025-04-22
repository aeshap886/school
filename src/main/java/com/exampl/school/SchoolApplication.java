package com.exampl.school;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = {"com.exampl", "SecurityConfiguration"})
@EntityScan("entity")
@ComponentScan(basePackages = {"com.exampl.controller", "SecurityConfiguration","com.exampl.repository","Service"})
@EnableJpaRepositories(basePackages = "com.exampl.repository")
public class SchoolApplication {
    public static void main(String[] args) {
        SpringApplication.run(SchoolApplication.class, args);
    }
}
