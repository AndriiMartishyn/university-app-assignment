package com.martishyn.universityapp;

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
    private static final String WHO_IS_HEAD_INPUT = "Who is head of department";
    private static final String SHOW_STATISTICS_INPUT = "Show %s statistics";
    private static final String SHOW_SALARY_INPUT = "Show the average";
    private static final String SHOW_COUNT_INPUT = "Show count";
    private static final String GLOBAL_SEARCH_INPUT = "Global search by {template}";
    private final ConsoleProcessingService inputService;

    public static void main(String[] args) {
        SpringApplication.run(UniversityAppApplication.class, args);
    }

    @Bean
    public CommandLineRunner startup() {
        return args -> {
            executeBusinessLogic();
        };
    }

    private void executeBusinessLogic() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to our simple CLI university application");
        while (true) {
            var command = scanner.nextLine();
            if (command.equals("exit")) {
                System.out.println("Exit from application.");
                break;
            }
            try {
                if (command.startsWith(WHO_IS_HEAD_INPUT)) {
                    inputService.printDepartmentHead(command, WHO_IS_HEAD_INPUT);
                } else if (command.startsWith(SHOW_STATISTICS_INPUT)) {
                    inputService.printDepartmentStatistics(command);
                } else if (command.startsWith(SHOW_SALARY_INPUT)) {
                    inputService.printAverageDepartmentSalary(command);
                } else if (command.startsWith(SHOW_COUNT_INPUT)) {
                    inputService.printNumberOfLectors(command);
                } else if (command.startsWith(GLOBAL_SEARCH_INPUT)) {
                    inputService.printGlobalSearchResult(command);
                } else {
                    System.out.println("There is no such command: " + command);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
