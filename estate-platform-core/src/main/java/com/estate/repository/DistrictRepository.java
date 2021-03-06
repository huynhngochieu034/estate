package com.estate.repository;

import com.estate.entity.DistrictEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DistrictRepository extends JpaRepository<DistrictEntity, Long> {

}
