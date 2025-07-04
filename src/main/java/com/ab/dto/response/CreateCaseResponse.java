package com.ab.dto.response;

import lombok.Data;

import java.util.Map;

@Data
public class CreateCaseResponse {
    private Long caseNumber;

    private Map<Integer,String> planNames;
}

