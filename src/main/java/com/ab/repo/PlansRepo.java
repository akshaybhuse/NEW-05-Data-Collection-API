package com.ab.repo;

import com.ab.entity.PlansEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlansRepo extends JpaRepository<PlansEntity,Integer> {
}
