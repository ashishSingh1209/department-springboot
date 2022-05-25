package com.example.departmentservice.responsedto;

import com.example.departmentservice.enums.EmployeeStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeResponseDto {
    private String employeeCode;

    private String employeeName;

    private String departmentId;

    private EmployeeStatus status;

}
