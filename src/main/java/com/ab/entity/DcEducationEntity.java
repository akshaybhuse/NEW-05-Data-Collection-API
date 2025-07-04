package com.ab.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "Tbl_DC_Education")
public class DcEducationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer educationId;

    private Long caseNumber;

    private String highestQualification;

    private Integer graduationYear;


}
