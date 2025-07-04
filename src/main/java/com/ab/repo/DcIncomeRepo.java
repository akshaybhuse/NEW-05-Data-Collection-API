package com.ab.repo;

import com.ab.entity.DcIncomeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DcIncomeRepo extends JpaRepository<DcIncomeEntity,Integer> {

    DcIncomeEntity findByCaseNumber(Long caseNumber);
}
