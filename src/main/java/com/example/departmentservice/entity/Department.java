package com.example.departmentservice.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "department_table")
public class Department {

    @Id
    @GenericGenerator(name = "department_code", strategy = "com.example.departmentservice.departmentCodeGenerator.DepartmentIDGenerator")
    @GeneratedValue(generator = "department_code")
    @Column(name = "department_id")
    private String departmentId;




    @Column(name = "department_code")
    private String departmentCode;

    @Column(name = "department_name")
    private String departmentName;
}
