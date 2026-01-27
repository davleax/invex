package com.mx.invex.dto;

import com.mx.invex.entity.Employee;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Date;

@Getter
@Setter
public class EmployeeDto {

    private Long id;
    private String firstName;
    private String secondName;
    private String lastName;
    private String maternalLastName;
    private Long age;
    private String sex;
    private LocalDate birthdate;
    private String position;
    private Date dateRegistration;
    private Boolean active;

    public EmployeeDto(){

    }

    public EmployeeDto(Employee employee) {
        this.firstName = employee.getFirstName();
        this.secondName = employee.getFirstName();
        this.lastName = employee.getLastName();
        this.maternalLastName = employee.getMaternalLastName();
        this.age = employee.getAge();
        this.sex = employee.getSex();
        this.birthdate = employee.getBirthdate();
        this.position = employee.getPosition();
        this.active = employee.getActive();
        this.dateRegistration = employee.getDateRegistration();
    }
}
