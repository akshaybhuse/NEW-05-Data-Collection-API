package com.ab.repo;

import com.ab.entity.DcEducationEntity;
import com.ab.entity.DcIncomeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DcEducationRepo extends JpaRepository<DcEducationEntity,Integer> {
    DcEducationEntity findByCaseNumber(Long caseNumber);
}
