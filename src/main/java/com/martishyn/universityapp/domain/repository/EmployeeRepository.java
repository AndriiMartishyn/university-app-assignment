package com.martishyn.universityapp.domain.repository;

import com.martishyn.universityapp.domain.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("select e from Employee e where (e.firstName=:template or " +
            "e.lastName=:template)")
    List<Employee> findEmployeesByFirstNameOrLastName(String template);
}
