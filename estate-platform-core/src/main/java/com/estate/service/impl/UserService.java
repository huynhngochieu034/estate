package com.estate.service.impl;

import com.estate.constant.SystemConstant;
import com.estate.converter.UserConverter;
import com.estate.dto.UserDTO;
import com.estate.entity.UserEntity;
import com.estate.repository.BuildingRepository;
import com.estate.repository.UserRepository;
import com.estate.repository.paging.Pageable;
import com.estate.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UserService  implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserConverter userConverter;


    @Override
    public Map<String, String> getUsers() {
        Map<String, String> results = new HashMap<>();
        userRepository.findByStatusAndRoles_Code(1, SystemConstant.USER_ROLE).forEach(item -> {
            results.put(item.getUserName(), item.getFullName());
        });
        return results;
    }

    @Override
    public List<UserDTO> findUser(Long buildingId) {
        boolean isChecked = false;
        List<UserDTO> userList = userRepository.findByStatusAndRoles_Code(1, SystemConstant.USER_ROLE)
                .stream().map(item -> userConverter.convertToDto(item)).collect(Collectors.toList());
        for(UserDTO item: userList){
            isChecked = userRepository.existsByUserNameAndBuildingsId(item.getUserName(), buildingId);
            if(isChecked){
                item.setChecked("checked");
            }
        }
        return userList;
    }




}
