package com.alex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SpringBootRefresherApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootRefresherApplication.class, args);
	}

    @GetMapping
    public String helloThere() {
        return "I am once again saying hello";
    }

}
