package com.ab.repo;

import com.ab.entity.DcChildrensEntity;
import com.ab.entity.DcIncomeEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DcChildrensRepo extends JpaRepository<DcChildrensEntity,Integer> {

    List<DcChildrensEntity> findByCaseNumber(Long caseNumber);
}
