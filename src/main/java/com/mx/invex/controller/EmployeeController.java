package com.mx.invex.controller;

import com.mx.invex.dto.EmployeeDto;
import com.mx.invex.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {


    private final EmployeeService employeeService;


    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<EmployeeDto> getAllEmployess(){
        return employeeService.getAllEmployees();
    }

    @PostMapping
    public EmployeeDto  createEmployee(@RequestBody EmployeeDto employeeDto){
        return employeeService.saveEmployee(employeeDto);

    }
    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id){
        Optional<EmployeeDto> employeeDto =employeeService.getEmployeeById(id);
        return employeeDto.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());

    }
}
