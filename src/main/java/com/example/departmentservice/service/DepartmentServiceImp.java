package com.example.departmentservice.service;

import com.example.departmentservice.RequestPayloads.DepartmentRequestPayload;
import com.example.departmentservice.customizedExceptions.DepartmentExceptions;
import com.example.departmentservice.dao.DepartmentService;
import com.example.departmentservice.entity.Department;
import com.example.departmentservice.repository.DepartmentRepository;
import com.example.departmentservice.responsedto.DepartmentResponseDto;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;


@Service
@Log4j2
public class DepartmentServiceImp implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;


    @Override
    public DepartmentResponseDto createDepartment(DepartmentRequestPayload departmentPayLoad) {
        Department department = new Department();
        BeanUtils.copyProperties(departmentPayLoad, department);
        departmentRepository.save(department);
        DepartmentResponseDto departmentResponseDto = new DepartmentResponseDto();
        BeanUtils.copyProperties(department, departmentResponseDto);
        return departmentResponseDto;


    }

    @Override
    @Transactional(readOnly = true)
    public List<DepartmentResponseDto> getAllDepartment() {
        List<Department> departmentList= departmentRepository.findAll();
        List<DepartmentResponseDto> departmentResponseDtoList  = new ArrayList<>();
        departmentList.forEach(department -> {
            DepartmentResponseDto departmentResponseDto = new DepartmentResponseDto();
            BeanUtils.copyProperties(department,departmentResponseDto);
            departmentResponseDtoList.add(departmentResponseDto);
        });


        if (departmentList.size() == 0) throw new DepartmentExceptions("There is no any department");
        return departmentResponseDtoList;
    }

    @Override
    @Transactional
    public String deleteDepartmentById(String departmentId) {
        log.info("inside department service implementation department id is {}", departmentId);
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(() -> new DepartmentExceptions("No such department id found"));
        if (!Objects.isNull(department))
            departmentRepository.deleteById(departmentId);
        return "Department deleted with department code: " + departmentId;
    }

    @Override
    public List<String> getOnlyDepartmentNames() {
        log.info("Inside getOnlyDepartmentNames of departmentServiceImp");
        TreeSet<Department> listOfDepartmentName = new TreeSet<>(new DepartmentNamesComaparator());
        listOfDepartmentName.addAll(departmentRepository.findAll());
        if (listOfDepartmentName.size() == 0) throw new DepartmentExceptions("There is no any department name");
        List<String> list = new ArrayList<>();
        listOfDepartmentName.forEach(department -> list.add(department.getDepartmentName()));
        return list;
    }


}
