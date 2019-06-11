package com.estate.repository;

import com.estate.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findOneByUserName(String name);
    List<UserEntity> findByStatusAndRoles_Code(Integer status, String role);
    boolean existsByUserNameAndBuildingsId(String userName, Long buildingId);
    boolean existsByIdAndBuildingPriorities_Id(Long  userId, Long buildingId);

}
