package com.mx.invex.service.impl;

import com.mx.invex.dto.EmployeeDto;
import com.mx.invex.entity.Employee;
import com.mx.invex.repository.EmployeeRepository;
import com.mx.invex.service.EmployeeService;
import com.mx.invex.util.Constants;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EmployyeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployyeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }


    @Override
    public List<EmployeeDto> getAllEmployees() {
        log.info(Constants.SEARCH_EMPLOYEE);
        return employeeRepository.findAll().stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Optional<EmployeeDto> getEmployeeById(Long id) {

        return employeeRepository.findById(id).map(this::convertToDTO);
    }

    @Override
    public EmployeeDto saveEmployee(EmployeeDto employeeDTO) {

        Employee employee = convertToEntity(employeeDTO);
        Employee savedEmployee= employeeRepository.save(employee);
        return convertToDTO(savedEmployee);
    }

    @Override
    public EmployeeDto updateEmployee(Long id, EmployeeDto employeeDTO) {

        Employee employee = employeeRepository.findById(id).orElseThrow();
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setSecondName(employeeDTO.getSecondName());
        employee.setMaternalLastName(employeeDTO.getMaternalLastName());
        employee.setLastName(employeeDTO.getMaternalLastName());
        Employee updatedEmployed = employeeRepository.save(employee);
        return convertToDTO(updatedEmployed);

    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public List<EmployeeDto> findEmployeeByName(String firstName) {
        return employeeRepository.findEmployeeByFirstNameContainingIgnoreCase(firstName).stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private EmployeeDto convertToDTO(Employee employee){
        return  new EmployeeDto(employee);
    }

    private Employee convertToEntity(EmployeeDto employeeDto){
        Employee employee = new Employee();
        employee.setFirstName(employeeDto.getFirstName());
        employee.setSecondName(employeeDto.getSecondName());
        employee.setLastName(employee.getLastName());
        employee.setMaternalLastName(employee.getMaternalLastName());
        employee.setAge(employeeDto.getAge());
        employee.setSex(employeeDto.getSex());
        employee.setBirthdate(employeeDto.getBirthdate());
        employee.setPosition(employeeDto.getPosition());
        employee.setActive(employeeDto.getActive());
        employee.setDateRegistration(new Date());
        return employee;
    }
}
