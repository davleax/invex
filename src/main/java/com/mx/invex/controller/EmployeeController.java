package com.mx.invex.controller;

import com.mx.invex.dto.EmployeeDto;
import com.mx.invex.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import com.mx.invex.util.Constants;

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
    @GetMapping(Constants.ID_SEARCH)
    public ResponseEntity<EmployeeDto> getEmployeeById(@PathVariable Long id){
        Optional<EmployeeDto> employeeDto =employeeService.getEmployeeById(id);
        return employeeDto.map(ResponseEntity::ok).orElseGet(()-> ResponseEntity.notFound().build());

    }

    @PutMapping(Constants.ID_SEARCH)
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable Long id, @RequestBody EmployeeDto dto){
        try{

            EmployeeDto employeeDto = employeeService.updateEmployee(id, dto);
            return  ResponseEntity.ok(employeeDto);
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping(Constants.ID_SEARCH)
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }


    @GetMapping(Constants.ID_SEARCH_BY_NAME)
    public List<EmployeeDto> getAllEmployessByname(@PathVariable String name){

        return employeeService.findEmployeeByName(name);
    }

}
