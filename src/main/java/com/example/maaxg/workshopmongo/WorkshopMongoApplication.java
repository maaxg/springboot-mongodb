package com.example.maaxg.workshopmongo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Collections;

@SpringBootApplication
public class WorkshopMongoApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(WorkshopMongoApplication.class);
        app.setDefaultProperties(Collections.singletonMap("server.port", "3030"));
        app.run(args);;
    }

}
