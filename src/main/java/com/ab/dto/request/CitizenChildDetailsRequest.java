package com.ab.dto.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class CitizenChildDetailsRequest {
    private Integer childrenId;

    private Long caseNumber;

    private LocalDate dateOfBirth;

    private Long ssn;
}
