package com.mx.invex.repository;

import com.mx.invex.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findEmployeeByFirstName(String firstName);
}

