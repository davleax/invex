package com.mx.invex.service;

import com.mx.invex.dto.EmployeeDto;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    List<EmployeeDto> getAllEmployees();
    Optional<EmployeeDto> getEmployeeById(Long id);
    EmployeeDto saveEmployee(EmployeeDto employeeDTO);
    EmployeeDto updateEmployee(Long id, EmployeeDto employeeDTO);
    void deleteEmployee(Long id);
}
