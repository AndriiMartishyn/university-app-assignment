package com.martishyn.universityapp.service;

import com.martishyn.universityapp.domain.service.ConsoleProcessingService;
import com.martishyn.universityapp.domain.service.UniversityService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.system.CapturedOutput;
import org.springframework.boot.test.system.OutputCaptureExtension;

import java.math.BigDecimal;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@ExtendWith(OutputCaptureExtension.class)
public class ConsoleProcessingServiceTest {
    private static final String WHO_IS_HEAD_PATTERN = "Who is head of department";
    private static final String WHO_IS_HEAD_USER_INPUT = "Who is head of department computer science";
    private static final String GLOBAL_SEARCH_PATTERN = "Global search by";
    private static final String GLOBAL_SEARCH_USER_INPUT = "Global search by xy";
    private static final String DEPARTMENT_HEAD = "x y";
    private static final String DEPARTMENT_NAME = "computer science";
    private static final BigDecimal AVG_SALARY = new BigDecimal(1333);
    private static final int EMPLOYEE_NUMBER = 3;

    @InjectMocks
    ConsoleProcessingService consoleProcessingService;
    @Mock
    UniversityService universityService;

    @DisplayName("should_print_department_head")
    @Test
    void printDepartmentHead_WhenPassingCorrectInput_ShouldPrintDepartmentName(CapturedOutput capturedOutput) {
        when(universityService.getDepartmentHead(DEPARTMENT_NAME)).thenReturn(DEPARTMENT_HEAD);

        consoleProcessingService.printDepartmentHead(WHO_IS_HEAD_USER_INPUT, WHO_IS_HEAD_PATTERN);

        Assertions.assertTrue(capturedOutput.toString().contains("Head of computer science department is x, y"));
    }

    @DisplayName("should_print_department_statistics")
    @Test
    void printDepartmentStatistics_WhenPassingCorrectInput_ShouldPrintStatistics(CapturedOutput capturedOutput) {
        when(universityService.getEmployeeStatistics(DEPARTMENT_NAME)).thenReturn(DEPARTMENT_HEAD);

        consoleProcessingService.printDepartmentStatistics(DEPARTMENT_NAME);

        Assertions.assertTrue(capturedOutput.toString().contains("x y - 1"));
    }

    @DisplayName("should_print_average_salary")
    @Test
    void printAverageSalary_WhenPassingCorrectInput_ShouldPrintSalary(CapturedOutput capturedOutput) {
        when(universityService.getAverageSalaryForDepartment(DEPARTMENT_NAME)).thenReturn(AVG_SALARY);

        consoleProcessingService.printAverageDepartmentSalary(DEPARTMENT_NAME);

        Assertions.assertTrue(capturedOutput.toString().contains("1333"));
    }

    @DisplayName("should_print_number_of_employees")
    @Test
    void printEmployeeCount_WhenPassingCorrectInput_ShouldPrintEmployeeCount(CapturedOutput capturedOutput) {
        when(universityService.getEmployeeCountInDepartment(DEPARTMENT_NAME)).thenReturn(EMPLOYEE_NUMBER);

        consoleProcessingService.printNumberOfEmployees(DEPARTMENT_NAME);

        Assertions.assertTrue(capturedOutput.toString().contains("3"));
    }


    @DisplayName("should_print_search_result")
    @Test
    void printGlobalSearchResult_WhenPassingCorrectInput_ShouldPrintSearchResult(CapturedOutput capturedOutput) {
        when(universityService.searchForEmployee("xy")).thenReturn(DEPARTMENT_HEAD);

        consoleProcessingService.printGlobalSearchResult(GLOBAL_SEARCH_USER_INPUT, GLOBAL_SEARCH_PATTERN );

        Assertions.assertTrue(capturedOutput.toString().contains(DEPARTMENT_HEAD));
    }







}
