package com.ab.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Data
@Table(name = "Tbl_DC_Childrens")
public class DcChildrensEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer childrenId;

    private Long caseNumber;

    private LocalDate dateOfBirth;

    private Long ssn;
}
