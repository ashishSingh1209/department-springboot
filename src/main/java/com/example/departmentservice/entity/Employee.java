package com.example.departmentservice.entity;


import com.example.departmentservice.enums.EmployeeStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.GenericGenerators;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name = "employee_table")
public class Employee {

    @Id
    @GenericGenerator(name = "employee_code_generator", strategy = "com.example.departmentservice.departmentCodeGenerator.EmployeeIDGenerator")
    @GeneratedValue(generator = "employee_code_generator")
    private String employeeCode;
    @Column(name = "employee_name")
    private String employeeName;
    @Column(name = "departmentId")
    private String departmentId;

    @Enumerated(EnumType.STRING)
    private EmployeeStatus status;
}
