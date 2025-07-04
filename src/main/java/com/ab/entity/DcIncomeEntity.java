package com.ab.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Tbl_DC_Income")
public class DcIncomeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer incomeId;

    private Long caseNumber;

    private Double empIncome;

    private Double propertyIncome;
}
