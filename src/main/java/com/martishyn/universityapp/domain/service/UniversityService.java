package com.martishyn.universityapp.domain.service;

import java.math.BigDecimal;

public interface UniversityService {

    String getDepartmentHead(String departmentName);

    String getEmployeeStatistics(String departmentName);

    BigDecimal getAverageSalaryForDepartment(String departmentName);

    int getEmployeeNumberForDepartment(String departmentName);

    String searchForEmployee(String searchPattern);
}
