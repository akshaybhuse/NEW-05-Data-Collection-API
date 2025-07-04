package com.ab.repo;

import com.ab.entity.OfficeVisitedCitizenDataEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OfficeVisitedCitizenRepo extends JpaRepository<OfficeVisitedCitizenDataEntity, Integer> {
}
