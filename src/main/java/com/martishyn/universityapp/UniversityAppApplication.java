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
    private static final String GLOBAL_SEARCH_INPUT = "Global search by";
    private final ConsoleProcessingService inputService;

    public static void main(String[] args) {
        SpringApplication.run(UniversityAppApplication.class, args);
    }

    @Bean
    public CommandLineRunner startup() {
        return args -> executeBusinessLogic();
    }

    private void executeBusinessLogic() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to our simple CLI university application");
        while (true) {
            var userInput = scanner.nextLine().trim();
            if (userInput.equals("exit")) {
                System.out.println("Exit from application.");
                break;
            }
            try {
                if (userInput.startsWith(WHO_IS_HEAD_INPUT)) {
                    inputService.printDepartmentHead(userInput, WHO_IS_HEAD_INPUT);
                } else if (userInput.startsWith(SHOW_STATISTICS_INPUT)) {
                    inputService.printDepartmentStatistics(userInput);
                } else if (userInput.startsWith(SHOW_SALARY_INPUT)) {
                    inputService.printAverageDepartmentSalary(userInput);
                } else if (userInput.startsWith(SHOW_COUNT_INPUT)) {
                    inputService.printNumberOfEmployees(userInput);
                } else if (userInput.startsWith(GLOBAL_SEARCH_INPUT)) {
                    inputService.printGlobalSearchResult(userInput, GLOBAL_SEARCH_INPUT);
                } else {
                    System.out.println("There is no such userInput: " + userInput);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
