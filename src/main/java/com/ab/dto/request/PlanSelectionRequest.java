package com.ab.dto.request;

import lombok.Data;

@Data
public class PlanSelectionRequest {

    private Integer visitedCitizenAppId;

    private Long caseNumber;

    private String planName;

    private Integer planId;
}
