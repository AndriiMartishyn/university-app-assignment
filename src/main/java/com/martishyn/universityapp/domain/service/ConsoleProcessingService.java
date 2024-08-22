package com.martishyn.universityapp.domain.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class ConsoleProcessingService {

    private static final String DEPARTMENT_HEAD_OUTPUT = "Head of %s department is %s";
    private static final String AVERAGE_SALARY_OUTPUT = "The average salary of %s is %s";
    private final UniversityService universityService;

    public void printDepartmentHead(String departmentName, String userInput) {
        String department = departmentName.substring(userInput.length());
        String departmentHead = universityService.getDepartmentHead(departmentName);
        System.out.printf(DEPARTMENT_HEAD_OUTPUT, department, departmentHead);
    }

    public void printDepartmentStatistics(String departmentName) {
        String employeeStatistics = universityService.getEmployeeStatistics(departmentName);
        System.out.println(employeeStatistics);
    }

    public void printAverageDepartmentSalary(String departmentName) {
        BigDecimal averageSalaryForDepartment = universityService.getAverageSalaryForDepartment(departmentName);
        System.out.printf(AVERAGE_SALARY_OUTPUT, departmentName, averageSalaryForDepartment);
    }

    public void printNumberOfLectors(String departmentName) {
        int employeeNumberForDepartment = universityService.getEmployeeNumberForDepartment(departmentName);
        System.out.println(employeeNumberForDepartment);
    }

    public void printGlobalSearchResult(String departmentName) {
        String searchResult = universityService.searchForEmployee(departmentName);
        System.out.println(searchResult);
    }
}
