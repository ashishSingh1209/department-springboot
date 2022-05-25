package com.example.departmentservice.dao;

import com.example.departmentservice.RequestPayloads.EmployeeRequestPayload;
import com.example.departmentservice.entity.Employee;
import com.example.departmentservice.responsedto.EmployeeResponseDto;

public interface EmployeeService {
    EmployeeResponseDto createEmployee(EmployeeRequestPayload employeeRequestPayload);
}
