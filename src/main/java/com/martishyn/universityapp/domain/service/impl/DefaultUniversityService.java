package com.martishyn.universityapp.domain.service.impl;

import com.martishyn.universityapp.domain.model.Department;
import com.martishyn.universityapp.domain.model.Employee;
import com.martishyn.universityapp.domain.repository.DepartmentRepository;
import com.martishyn.universityapp.domain.repository.EmployeeRepository;
import com.martishyn.universityapp.domain.service.UniversityService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class DefaultUniversityService implements UniversityService {

    private final DepartmentRepository departmentRepository;
    private final EmployeeRepository employeeRepository;

    @Override
    public String getDepartmentHead(String departmentName) {
        Department foundDepartment = departmentRepository.findDepartmentByNameEqualsIgnoreCase(departmentName)
                .orElseThrow(() -> new EntityNotFoundException("No department found with such name: " + departmentName));
        Employee departmentHead = foundDepartment.getDepartmentHead();
        return departmentHead.getFirstName() + " " + departmentHead.getLastName() + System.lineSeparator();
    }

    @Override
    public String getEmployeeStatistics(String departmentName) {
        Department foundDepartment = departmentRepository.findDepartmentByNameEqualsIgnoreCase(departmentName)
                .orElseThrow(() -> new EntityNotFoundException("No department found with such name: " + departmentName));
        Set<Employee> employees = foundDepartment.getEmployees();
        Map<String, Long> degreeToNumberMap = employees.stream()
                .map(Employee::getDegree)
                .collect(Collectors.groupingBy(
                        degree -> degree.toString().toLowerCase(),
                        Collectors.counting()
                ));
        StringBuilder statisticsResult = new StringBuilder();
        degreeToNumberMap.forEach((key, value) -> {
            statisticsResult.append(key);
            statisticsResult.append("s");
            statisticsResult.append(" - ");
            statisticsResult.append(value);
            statisticsResult.append(System.lineSeparator());
        });
        return statisticsResult.toString();
    }

    @Override
    public BigDecimal getAverageSalaryForDepartment(String departmentName) {
        return departmentRepository.findAverageSalaryInDepartment(departmentName)
                .orElseThrow(() -> new EntityNotFoundException("No department found with such name: " + departmentName));
    }

    @Override
    public int getEmployeeCountInDepartment(String departmentName) {
        return departmentRepository.countEmployeesForDepartment(departmentName);
    }

    @Override
    public String searchForEmployee(String searchPattern) {
        return String.join(", ", employeeRepository.findEmployeesByFirstNameOrLastName(searchPattern));
    }
}
