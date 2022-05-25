package com.example.departmentservice.customizedExceptions;

import java.util.function.Supplier;

public class DepartmentExceptions extends RuntimeException {
    public DepartmentExceptions(String message) {
        super(message);
    }

    public DepartmentExceptions(Throwable throwable) {
        super(throwable);
    }


    public DepartmentExceptions(String message, Throwable throwable) {
        super(message, throwable);
    }


    public DepartmentExceptions() {

    }


}
