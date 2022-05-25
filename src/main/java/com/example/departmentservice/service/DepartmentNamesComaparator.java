package com.example.departmentservice.service;

import com.example.departmentservice.entity.Department;

import java.util.Comparator;

public class DepartmentNamesComaparator implements Comparator {
    @Override
    public int compare(Object o, Object t1){
        String departmentName1 = ((Department)o).getDepartmentName();
        String departmentName2 = ((Department)t1).getDepartmentName();
        return departmentName1.compareTo(departmentName2);
    }
}
