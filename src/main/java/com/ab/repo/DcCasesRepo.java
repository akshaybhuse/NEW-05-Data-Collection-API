package com.ab.repo;

import com.ab.entity.DcCasesEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DcCasesRepo extends JpaRepository<DcCasesEntity,Integer> {

    public DcCasesEntity findByVisitedCitizenAppId(Integer visitedCitizenAppId);
}
