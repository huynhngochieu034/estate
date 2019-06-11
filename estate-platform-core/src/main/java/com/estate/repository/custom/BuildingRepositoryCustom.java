package com.estate.repository.custom;


import com.estate.builder.BuildingBuilder;
import com.estate.entity.BuildingEntity;
import org.springframework.data.domain.Pageable;


import java.util.List;
import java.util.Map;

public interface BuildingRepositoryCustom {
    /*JPA custom*/
    List<BuildingEntity> findAll(BuildingBuilder builder, Pageable pageable);
    Long getTotalItems(BuildingBuilder builder);
}
