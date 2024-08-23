package com.martishyn.universityapp.domain.repository;

import com.martishyn.universityapp.domain.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Set;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("SELECT CONCAT(e.firstName, ' ', e.lastName) FROM Employee e WHERE LOWER(CONCAT(e.firstName, ' ', e.lastName)) LIKE LOWER(CONCAT('%', :template, '%')) ")
    List<String> findEmployeesByFirstNameOrLastName(String template);

}
