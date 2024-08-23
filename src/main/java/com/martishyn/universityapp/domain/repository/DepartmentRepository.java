package com.martishyn.universityapp.domain.repository;

import com.martishyn.universityapp.domain.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.math.BigDecimal;
import java.util.Optional;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    Optional<Department> findDepartmentByNameEqualsIgnoreCase(String departmentName);

    @Query("SELECT avg(e.salary) FROM Employee e JOIN e.departments d WHERE d.name = :departmentName")
    Optional<BigDecimal> findAverageSalaryInDepartment(String departmentName);

    @Query("SELECT count(d) FROM Department d JOIN d.employees WHERE d.name= :departmentName")
    Integer countEmployeesForDepartment(String departmentName);

}
