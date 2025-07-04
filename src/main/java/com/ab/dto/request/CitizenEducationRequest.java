package com.ab.dto.request;

import lombok.Data;

@Data
public class CitizenEducationRequest {

    private Integer educationId;

    private Long caseNumber;

    private String highestQualification;

    private Integer graduationYear;
}
