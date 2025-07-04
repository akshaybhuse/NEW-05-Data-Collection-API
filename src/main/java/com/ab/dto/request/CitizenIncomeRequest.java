package com.ab.dto.request;

import lombok.Data;

@Data
public class CitizenIncomeRequest {
    private Integer incomeId;

    private Long caseNumber;

    private Double empIncome;

    private Double propertyIncome;
}
