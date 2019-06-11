package com.estate.service.impl;


import com.estate.builder.BuildingBuilder;
import com.estate.constant.SystemConstant;
import com.estate.converter.BuildingConverter;

import com.estate.dto.BuildingDTO;
import com.estate.dto.UserDTO;
import com.estate.entity.BuildingEntity;
import com.estate.entity.UserEntity;
import com.estate.enums.BuildingType;
import com.estate.repository.BuildingRepository;
import com.estate.repository.UserRepository;
import com.estate.utils.SecurityUtils;
import org.apache.commons.codec.binary.Base64;
import com.estate.service.IBuildingService;
import com.estate.utils.UploadFileUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.security.Security;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class BuildingService implements IBuildingService {


    @Autowired
    private BuildingRepository buildingRepository;

    @Autowired
    private BuildingConverter buildingConverter;

    @Autowired
    private UserRepository userRepository;

    //Spring data JPA
    @Override
    public List<BuildingDTO> findAll(BuildingDTO model, Pageable pageable) {
        if(model.getUrlMapping().equals("/admin/building/assignment")){
         model.setStaffName(userRepository.findOne(SecurityUtils.getPrincipal().getId()).getUserName());
        }
        List<BuildingEntity> buildingEntities = buildingRepository.findAll(getBuildingBuilder(model), pageable);
        List<BuildingDTO> buildingDTOS = buildingEntities.stream().map(item -> buildingConverter.convertToDto(item)).collect(Collectors.toList());
        boolean isPriority = false;
        for(BuildingDTO item: buildingDTOS){
            isPriority = userRepository.existsByIdAndBuildingPriorities_Id(SecurityUtils.getPrincipal().getId(), item.getId());
            if(isPriority){
                item.setPriority(true);
            }
        }
        return buildingDTOS;
    }

    @Override
    @Transactional
    public BuildingDTO save(BuildingDTO buildingDTO) {
        buildingDTO.setType();
        BuildingEntity buildingEntity = buildingConverter.convertToEntity(buildingDTO);
        if (buildingDTO.getBase64() != null) {
           writeImage(buildingDTO,buildingEntity);
        }
        buildingEntity = buildingRepository.save(buildingEntity);
        return buildingConverter.convertToDto(buildingEntity);
    }

    @Override
    @Transactional
    public BuildingDTO update(BuildingDTO updateBuilding) {
        updateBuilding.setType();
        BuildingEntity existBuilding= buildingRepository.findOne(updateBuilding.getId());
        BuildingEntity updateBuildingEntity = buildingConverter.convertToEntity(updateBuilding);
        updateBuildingEntity.setCreatedDate(existBuilding.getCreatedDate());
        updateBuildingEntity.setCreatedBy(existBuilding.getCreatedBy());
        if (updateBuilding.getBase64() != null) {
            writeImage(updateBuilding, updateBuildingEntity);
        }else{
            updateBuildingEntity.setImage(existBuilding.getImage());
        }
        existBuilding = buildingRepository.save(updateBuildingEntity);
        return buildingConverter.convertToDto(existBuilding);
    }

    @Override
    public BuildingDTO findById(long id) {
        BuildingEntity buildingEntity = buildingRepository.findOne(id);
        BuildingDTO result = buildingConverter.convertToDto(buildingEntity);
        if (buildingEntity.getType() != null) {
            result.setTypeArrays(buildingEntity.getType().split(","));
        }
        return result;
    }

    @Override
    public Map<String, String> getBuildingTypes() {
        Map<String, String> results = new HashMap<>();
        Stream.of(BuildingType.values()).forEach(type -> {
            results.put(type.name(), type.getValue());
        });
        return results;
    }





    @Override
    @Transactional
    public void deleteBuilding(long[] id) {
        for (long item : id) {
            buildingRepository.delete(item);
        }
    }

    @Override
    @Transactional
    public void assignUserToBuilding(long[] userIds, long buildingId) {
        BuildingEntity building = buildingRepository.findOne(buildingId);
        List<UserEntity> staffs = new ArrayList<>();
        for (long item : userIds) {
            staffs.add(userRepository.findOne(item));
        }
        building.setStaffs(staffs);
        buildingRepository.save(building);
    }

    @Override
    @Transactional
    public void updatePriority(String action, long id) {
        UserEntity user = userRepository.findOneByUserName(SecurityUtils.getPrincipal().getUsername());
        BuildingEntity building = buildingRepository.findOne(id);
        if (action.equals(SystemConstant.ACTION_INSERT)) {
            building.setUsers(Stream.of(user).collect(Collectors.toList()));
            user.setBuildingPriorities(Stream.of(building).collect(Collectors.toList()));
        } else if (action.equals(SystemConstant.ACTION_REMOVE)) {
            user.getBuildingPriorities().remove(building);
            building.getUsers().remove(user);
        }
        buildingRepository.save(building);
        userRepository.save(user);
    }

    @Override
    public int getTotalItems(BuildingDTO model) {
        return buildingRepository.getTotalItems(getBuildingBuilder(model)).intValue();
    }

    @Override
    public List<BuildingDTO> findAllPriorities(long userId, Pageable pageable) {
        Page<BuildingEntity> buildingsPage = buildingRepository.findByUsers_Id(userId, pageable);
        return buildingsPage.getContent().stream().map(item -> buildingConverter.convertToDto(item)).collect(Collectors.toList());
    }

    @Override
    public int getTotalItemPriorities(long userId) {
        return (int) buildingRepository.countByUsers_Id(userId);
    }

    private void writeImage(BuildingDTO buildingDTO, BuildingEntity buildingEntity){
        byte[] bytes = Base64.decodeBase64(buildingDTO.getBase64().getBytes());
        String path = "/building/"+buildingDTO.getImageName();
        UploadFileUtils.writeOrUpdate(path, bytes);
        buildingEntity.setImage(SystemConstant.HOME_BUILDING + path);
    }

    private BuildingBuilder getBuildingBuilder(BuildingDTO model) {
        return new BuildingBuilder.Builder()
                .setBuildingName(model.getBuildingName())
                .setAreaFrom(model.getAreaFrom())
                .setAreaTo(model.getAreaTo())
                .setBasementNumber(model.getBasementNumber())
                .setBuildingArea(model.getBuildingArea())
                .setCostFrom(model.getCostFrom())
                .setCostTo(model.getCostTo())
                .setDirection(model.getDirection())
                .setDistrict(model.getDistrict())
                .setLevel(model.getLevel())
                .setManagerName(model.getManagerName())
                .setManagerPhoneNumber(model.getManagerPhoneNumber())
                .setWard(model.getWard())
                .setStreet(model.getStreet())
                .setStaffName(model.getStaffName())
                .setTypeArrays(model.getTypeArrays())
                .setStaffName(model.getStaffName())
                .setStaffId(StringUtils.isNotBlank(model.getStaffName()) ? userRepository.findOneByUserName(model.getStaffName()).getId() : null)
                .build();
    }


}
