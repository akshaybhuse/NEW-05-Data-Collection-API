package com.ab.dto.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class OfficeVisitedCitizenDataRequest {

    private String fullName;

    private String email;

    private Long mobileNumber;

    private String gender;

    private LocalDate dob;

    private Long ssn;

}
