package com.mx.invex.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id", nullable = false)
    private Long id;

    @Column(name = "first_name", length = 50)
    private String firstName;

    @Column(name = "second_name", length = 50)
    private String secondName;

    @Column(name = "last_name", length = 50)
    private String lastName;

    @Column(name = "maternal_last_name", length = 50)
    private String maternalLastName;

    @Column(name = "age")
    private Long age;

    @Column(name = "sex", length = 50)
    private String sex;

    @Column(name = "birthdate")
    private LocalDate birthdate;

    @Column(name = "\"position\"", length = 50)
    private String position;

    @Column(name = "date_registration")
    private Date dateRegistration;

    @Column(name = "active")
    private Boolean active;


}