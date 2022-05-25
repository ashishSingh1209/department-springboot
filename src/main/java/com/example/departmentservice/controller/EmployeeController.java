package com.example.departmentservice.controller;


import com.example.departmentservice.RequestPayloads.EmployeeRequestPayload;
import com.example.departmentservice.ResponseDto.ResponseDTO;
import com.example.departmentservice.customizedExceptions.EmployeeException;
import com.example.departmentservice.dao.EmployeeService;
import com.example.departmentservice.entity.Employee;
import com.example.departmentservice.responsedto.EmployeeResponseDto;
import com.sun.istack.NotNull;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")
@Log4j2
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/")
    public ResponseDTO<EmployeeResponseDto> createEmployee(@RequestBody @NotNull EmployeeRequestPayload employee) {
        try {
            EmployeeResponseDto employee1 = employeeService.createEmployee(employee);
            return ResponseDTO.success("employee created successfully", employee1);
        } catch (EmployeeException e) {
            return ResponseDTO.failure(e.getMessage());
        }
    }
}
