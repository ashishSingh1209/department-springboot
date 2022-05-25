package com.example.departmentservice.dao;

import com.example.departmentservice.RequestPayloads.DepartmentRequestPayload;
import com.example.departmentservice.entity.Department;
import com.example.departmentservice.responsedto.DepartmentResponseDto;

import java.util.List;

public interface DepartmentService {
    DepartmentResponseDto createDepartment(DepartmentRequestPayload department);

    List<DepartmentResponseDto> getAllDepartment();

    String deleteDepartmentById(String departmentId);

    List<String> getOnlyDepartmentNames();
}
