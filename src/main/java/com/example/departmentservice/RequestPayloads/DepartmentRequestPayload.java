package com.example.departmentservice.RequestPayloads;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;

import javax.persistence.Column;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@JsonInclude(JsonInclude.Include.NON_NULL) //ignore all null fields
public class DepartmentRequestPayload {


    private String departmentId;
    private String departmentCode;
    private String departmentName;
}
