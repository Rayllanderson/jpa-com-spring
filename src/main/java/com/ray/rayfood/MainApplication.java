package com.ray.rayfood;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
//@ComponentScan("com.ray.service")
@ComponentScan("com.ray.domain.entities")
@ComponentScan("com.ray.rayfood.jpa")
@EntityScan(basePackages = {"com.ray.rayfood.domain.entities"}) 
@ComponentScan("com.ray.rayfood.infrastructure.repository")
@ComponentScan("com.ray.rayfood.api.controller")
@ComponentScan
public class MainApplication {

    public static void main(String[] args) {
	SpringApplication.run(MainApplication.class, args);
    }

}
