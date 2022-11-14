package com.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.backend.api.ProductAPI;

@SpringBootApplication()
public class Application {

       public static void main(String[] args) {

        SpringApplication.run(Application.class, args);

    }

}
