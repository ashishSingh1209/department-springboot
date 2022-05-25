package com.example.departmentservice.RequestPayloads;

import com.example.departmentservice.enums.EmployeeStatus;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.Column;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL) //ignore all null fields
public class EmployeeRequestPayload {

    private String employeeCode;

    private String employeeName;

    private String departmentId;

    private EmployeeStatus status;

}
