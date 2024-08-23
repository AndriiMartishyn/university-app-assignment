package com.martishyn.universityapp;

import com.martishyn.universityapp.domain.facade.UserInputFacade;
import com.martishyn.universityapp.domain.service.ConsoleProcessingService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Scanner;

@SpringBootApplication
@RequiredArgsConstructor
public class UniversityAppApplication {
    private final UserInputFacade userInputFacade;

    public static void main(String[] args) {
        SpringApplication.run(UniversityAppApplication.class, args);
    }

    @Bean
    public CommandLineRunner startup() {
        return args -> {
            Scanner scanner = new Scanner(System.in);
            userInputFacade.processUserRequest(scanner);
        };
    }
}
