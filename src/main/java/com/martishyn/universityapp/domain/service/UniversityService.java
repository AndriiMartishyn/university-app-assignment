package com.martishyn.universityapp.domain.service;

import com.martishyn.universityapp.domain.model.Employee;

import java.math.BigDecimal;
import java.util.List;

public interface UniversityService {

    String getDepartmentHead(String departmentName);

    String getEmployeeStatistics(String departmentName);

    BigDecimal getAverageSalaryForDepartment(String departmentName);

    int getEmployeeNumberForDepartment(String departmentName);

    String searchForEmployee(String searchPattern);
}
