package com.ab.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Tbl_DC_Cases")
public class DcCasesEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long caseNumber;

    private Integer visitedCitizenAppId;

    private Integer planId;

}
