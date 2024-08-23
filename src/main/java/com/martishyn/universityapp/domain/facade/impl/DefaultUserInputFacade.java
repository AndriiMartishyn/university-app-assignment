package com.martishyn.universityapp.domain.facade.impl;

import com.martishyn.universityapp.domain.facade.UserInputFacade;
import com.martishyn.universityapp.domain.service.ConsoleProcessingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
@RequiredArgsConstructor
public class DefaultUserInputFacade implements UserInputFacade {

    private static final String WELCOME_TEXT = "Welcome to our simple CLI university application";
    private static final String WHO_IS_HEAD_INPUT = "Who is head of department ";
    private static final String SHOW_STATISTICS_START = "Show ";
    private static final String SHOW_STATISTICS_END = "statistics";
    private static final String SHOW_SALARY_INPUT = "Show the average salary for the department ";
    private static final String SHOW_COUNT_INPUT = "Show count of employee for ";
    private static final String GLOBAL_SEARCH_INPUT = "Global search by ";
    private final ConsoleProcessingService consoleProcessingService;

    @Override
    public void processUserRequest(Scanner scanner) {
        System.out.println(WELCOME_TEXT);
        while (true) {
            var userInput = scanner.nextLine().trim();
            if (userInput.equals("exit")) {
                System.out.println("Exit from the application.");
                break;
            }
            try {
                if (commandStartsWith(userInput, WHO_IS_HEAD_INPUT)) {
                    consoleProcessingService.printDepartmentHead(userInput, WHO_IS_HEAD_INPUT);
                } else if (commandStartsWith(userInput, SHOW_STATISTICS_START) && userInput.endsWith(SHOW_STATISTICS_END)) {
                    consoleProcessingService.printDepartmentStatistics(userInput, SHOW_STATISTICS_START, SHOW_STATISTICS_END);
                } else if (userInput.startsWith(SHOW_SALARY_INPUT)) {
                    consoleProcessingService.printAverageDepartmentSalary(userInput, SHOW_SALARY_INPUT);
                } else if (userInput.startsWith(SHOW_COUNT_INPUT)) {
                    consoleProcessingService.printNumberOfEmployees(userInput, SHOW_COUNT_INPUT);
                } else if (userInput.startsWith(GLOBAL_SEARCH_INPUT)) {
                    consoleProcessingService.printGlobalSearchResult(userInput, GLOBAL_SEARCH_INPUT);
                } else {
                    System.out.println("There is no such command: " + userInput);
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public boolean commandStartsWith(String input, String command) {
        return input.startsWith(command) && input.length() >= command.length();
    }
}
