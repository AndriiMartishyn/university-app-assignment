package com.martishyn.universityapp.domain.repository;

import com.martishyn.universityapp.domain.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Optional<Department> findDepartmentByNameEqualsIgnoreCase(String departmentName);

    @Query("select avg(e.salary) from Department d join Employee e WHERE d.name = :departmentName")
    Optional<BigDecimal> findAverageSalaryInDepartment(String departmentName);

    @Query("select count(d.employees) from Department d WHERE d.name= :departmentName")
    int countEmployeesForDepartment(String departmentName);

}
