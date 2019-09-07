package com.senerutaxi;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.SecurityAutoConfiguration;

import javax.persistence.Persistence;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class Starter implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(Starter.class, args);


        Persistence.createEntityManagerFactory("myPersistenceUnit");
    }

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
    }
}
