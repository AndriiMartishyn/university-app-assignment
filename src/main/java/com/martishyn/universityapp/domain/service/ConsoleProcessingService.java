package com.martishyn.universityapp.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ConsoleProcessingService {

    private static final String DEPARTMENT_HEAD_OUTPUT = "Head of %s department is %s";
    private static final String AVERAGE_SALARY_OUTPUT = "The average salary of %s is %s";

    private final UniversityService universityService;

    public void printDepartmentHead(String userInput, String sentence) {
        String department = userInput.substring(sentence.length()).trim();
        String departmentHead = universityService.getDepartmentHead(department);
        System.out.printf(DEPARTMENT_HEAD_OUTPUT, department, departmentHead);
    }

    public void printDepartmentStatistics(String userInput, String showStatisticsStartString, String showStatisticsEndString) {
        String departmentName = userInput.substring(showStatisticsStartString.length(), userInput.indexOf(showStatisticsEndString)).trim();
        String employeeStatistics = universityService.getEmployeeStatistics(departmentName);
        System.out.println(employeeStatistics);
    }

    public void printAverageDepartmentSalary(String userInput, String showSalaryInput) {
        String departmentName = userInput.substring(showSalaryInput.length());
        BigDecimal averageSalaryForDepartment = universityService.getAverageSalaryForDepartment(departmentName);
        System.out.printf(AVERAGE_SALARY_OUTPUT, departmentName, averageSalaryForDepartment);
    }

    public void printNumberOfEmployees(String userInput, String showNumberOfEmployeeInput) {
        String departmentName = userInput.substring(showNumberOfEmployeeInput.length());
        int employeeCountInDepartment = universityService.getEmployeeCountInDepartment(departmentName);
        System.out.println(employeeCountInDepartment);
    }

    public void printGlobalSearchResult(String userInput, String sentence) {
        String template = userInput.substring(sentence.length());
        String searchResult = universityService.searchForEmployee(template.trim());
        System.out.println(searchResult);
    }
}
