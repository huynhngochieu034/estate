package com.estate.service;

import com.estate.dto.BuildingDTO;
import org.springframework.data.domain.Pageable;


import java.util.List;
import java.util.Map;

public interface IBuildingService {
    List<BuildingDTO> findAll(BuildingDTO model, Pageable pageable);
    BuildingDTO save(BuildingDTO newDTO);
    BuildingDTO update(BuildingDTO updateNew);
    BuildingDTO findById(long id);
    Map<String, String> getBuildingTypes();
    void deleteBuilding(long[] id);
    void assignUserToBuilding(long[] userIds, long buildingId);
    void updatePriority(String action, long id);
    int getTotalItems(BuildingDTO model);
    List<BuildingDTO> findAllPriorities(long userId, Pageable pageable);
    int getTotalItemPriorities(long userId);
}
