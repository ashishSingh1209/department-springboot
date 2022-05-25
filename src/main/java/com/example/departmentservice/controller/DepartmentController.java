package com.example.departmentservice.controller;


import com.example.departmentservice.RequestPayloads.DepartmentRequestPayload;
import com.example.departmentservice.ResponseDto.ResponseDTO;
import com.example.departmentservice.customizedExceptions.DepartmentExceptions;
import com.example.departmentservice.dao.DepartmentService;
import com.example.departmentservice.responsedto.DepartmentResponseDto;
import com.sun.istack.NotNull;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/department")
@Log4j2
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @ApiOperation("Create new department")
    @PostMapping(value = "/")
    public ResponseDTO<DepartmentResponseDto> createDepartment(@RequestBody @NotNull DepartmentRequestPayload department) {
        log.info("Department to create department{}", department);
        try {
            DepartmentResponseDto department1 = departmentService.createDepartment(department);
            return ResponseDTO.success("Department created successfully", department1);
        } catch (DepartmentExceptions departmentExceptions) {
            log.info("Error in creating department ", departmentExceptions);
            return ResponseDTO.failure(departmentExceptions.getMessage());
        } catch (Exception e) {
            log.info("Error in creating department", e);
            return ResponseDTO.failure("Error in creating department");
        }

    }

    @ApiOperation("Get all the list of department")
    @GetMapping(value = "/all")
    public ResponseDTO<List<DepartmentResponseDto>> getAllDepartment() {
        try {
            List<DepartmentResponseDto> departmentList = departmentService.getAllDepartment();
            return ResponseDTO.success("Department list fetched", departmentList);
        } catch (DepartmentExceptions departmentExceptions) {
            return ResponseDTO.failure(departmentExceptions.getMessage());
        }
    }

    @ApiOperation("Delete department from departmentId")
    @DeleteMapping(value = "/delete/{id}")
    public ResponseDTO<String>deleteDepartmentById(@PathVariable("id") @NotNull String departmentId) {
        try {
            log.info("deleting department by id: {}", departmentId);
            departmentService.deleteDepartmentById(departmentId);
            return ResponseDTO.success("Deleted department with departmentId" + departmentId);
        } catch (DepartmentExceptions departmentExceptions) {
            return ResponseDTO.failure(departmentExceptions.getMessage());
        } catch (Exception e) {
            return ResponseDTO.failure("Error in deleting department id");
        }


    }

    @ApiOperation("Department names list")
    @GetMapping("/names")
    public ResponseDTO<List<String>> departmentNames() {
        log.info("Fetching department name");
        try {
            List<String> departmentNameList = departmentService.getOnlyDepartmentNames();
            return ResponseDTO.success("Successfully fetched department name", departmentNameList);
        } catch (DepartmentExceptions departmentExceptions) {
            return ResponseDTO.failure(departmentExceptions.getMessage());
        } catch (Exception e) {
            return ResponseDTO.failure("Error in fetching department names");
        }

    }

}
