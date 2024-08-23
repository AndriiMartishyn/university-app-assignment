package com.martishyn.universityapp.domain.service;

import com.martishyn.universityapp.domain.model.Degree;
import com.martishyn.universityapp.domain.model.Department;
import com.martishyn.universityapp.domain.model.Employee;
import com.martishyn.universityapp.domain.repository.DepartmentRepository;
import com.martishyn.universityapp.domain.repository.EmployeeRepository;
import com.martishyn.universityapp.domain.service.impl.DefaultUniversityService;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class UniversityServiceTest {
    private static final String DEPARTMENT_NAME = "computer science";
    private static Department department;
    private static Employee testEmployee_1;
    private static Employee testEmployee_2;
    private static Set<Employee> employees = new HashSet<>();

    @InjectMocks
    private DefaultUniversityService universityService;
    @Mock
    private DepartmentRepository departmentRepository;
    @Mock
    private EmployeeRepository employeeRepository;

    @BeforeAll
    static void setUp() {
        department = new Department();
        testEmployee_1 = new Employee();
        testEmployee_1.setId(1L);
        testEmployee_1.setFirstName("x");
        testEmployee_1.setLastName("y");
        testEmployee_1.setDegree(Degree.ASSISTANT);
        testEmployee_1.setSalary(BigDecimal.valueOf(300));
        testEmployee_2 = new Employee();
        testEmployee_2.setId(2L);
        testEmployee_2.setFirstName("a");
        testEmployee_2.setLastName("b");
        testEmployee_2.setDegree(Degree.ASSISTANT);
        testEmployee_1.setSalary(BigDecimal.valueOf(400));
        department.setDepartmentHead(testEmployee_1);
        employees.add(testEmployee_1);
        employees.add(testEmployee_2);
        department.setEmployees(employees);
    }

    @DisplayName("should_return_department_head")
    @Test
    void shouldReturnDepartmentHeadNameWhenPassingCorrectData() {
        when(departmentRepository.findDepartmentByNameEqualsIgnoreCase(DEPARTMENT_NAME)).thenReturn(Optional.ofNullable(department));
        String expectedDepartmentHeadName = testEmployee_1.getFirstName() + " " + testEmployee_1.getLastName() + System.lineSeparator();

        String actualDepartmentHeadName = universityService.getDepartmentHead(DEPARTMENT_NAME);

        Assertions.assertEquals(expectedDepartmentHeadName, actualDepartmentHeadName);
    }

    @DisplayName("should_throw_exception_when_department_not_found")
    @Test
    void shouldThrowEntityNotFoundExceptionWhenPassingIncorrectDepartment() {
        when(departmentRepository.findDepartmentByNameEqualsIgnoreCase(DEPARTMENT_NAME)).thenReturn(Optional.empty());
        String expectedExceptionMessage = "No department found with such name: " + DEPARTMENT_NAME;

        EntityNotFoundException entityNotFoundException = Assertions.assertThrows(EntityNotFoundException.class, () ->
                universityService.getDepartmentHead(DEPARTMENT_NAME));

        Assertions.assertEquals(expectedExceptionMessage, entityNotFoundException.getMessage());
    }

    @DisplayName("should_get_employee_statistics")
    @Test
    void shouldReturnEmployeeStatisticsWhenPassingCorrectData() {
        when(departmentRepository.findDepartmentByNameEqualsIgnoreCase(DEPARTMENT_NAME)).thenReturn(Optional.ofNullable(department));
        String expectedStatistics = "assistants - 2" + System.lineSeparator();
        String actualEmployeeStatistics = universityService.getEmployeeStatistics(DEPARTMENT_NAME);

        Assertions.assertEquals(expectedStatistics, actualEmployeeStatistics);
    }

    @DisplayName("should_get_average_salary_in_department")
    @Test
    void shouldReturnAverageSalaryForDepartmentWhenPassingCorrectData() {
        when(departmentRepository.findAverageSalaryInDepartment(DEPARTMENT_NAME)).thenReturn(Optional.of(BigDecimal.valueOf(350)));
        BigDecimal expectedAverageSalary = BigDecimal.valueOf(350);

        BigDecimal actualAverageSalary = universityService.getAverageSalaryForDepartment(DEPARTMENT_NAME);

        Assertions.assertEquals(expectedAverageSalary, actualAverageSalary);
    }

    @DisplayName("should_print_employee_number_in_department")
    @Test
    void shouldReturnNumberOfEmployeesInDepartment() {
        when(departmentRepository.countEmployeesForDepartment(DEPARTMENT_NAME)).thenReturn(1);

        int actualEmployeeNumber = universityService.getEmployeeCountInDepartment(DEPARTMENT_NAME);

        Assertions.assertEquals(1, actualEmployeeNumber);
    }

    @DisplayName("should_return_employees_based_on_search_template")
    @Test
    void shouldReturnEmployeesBasedOnSearchTemplate() {
        when(employeeRepository.findEmployeesByFirstNameOrLastName("xa")).thenReturn(employees);
        String expectedSearchResult = "x y, a b";

        String actualSearchResult = universityService.searchForEmployee("xa");

        Assertions.assertEquals(expectedSearchResult, actualSearchResult);
    }
}
