package com.chatterbox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class ChatterBoxApplication {

    public static void main(String[] args) {
        SpringApplication.run(ChatterBoxApplication.class, args);
    }

   
}
