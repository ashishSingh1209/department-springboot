package com.example.departmentservice.service;

import com.example.departmentservice.RequestPayloads.EmployeeRequestPayload;
import com.example.departmentservice.customizedExceptions.EmployeeException;
import com.example.departmentservice.dao.EmployeeService;
import com.example.departmentservice.entity.Employee;
import com.example.departmentservice.repository.EmployeeRepository;
import com.example.departmentservice.responsedto.EmployeeResponseDto;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service

public class EmployeeServiceImp implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public EmployeeResponseDto createEmployee(EmployeeRequestPayload employeeRequestPayload) {
        Employee employee = new Employee();
        BeanUtils.copyProperties(employeeRequestPayload, employee);
        employeeRepository.save(employee);
        EmployeeResponseDto employeeResponseDto = new EmployeeResponseDto();
        BeanUtils.copyProperties(employee, employeeResponseDto);
        return employeeResponseDto;
    }
}
