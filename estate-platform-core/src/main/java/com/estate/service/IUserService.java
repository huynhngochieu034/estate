package com.estate.service;

import com.estate.dto.UserDTO;
import com.estate.entity.UserEntity;
import com.estate.repository.paging.Pageable;

import java.util.List;
import java.util.Map;

public interface IUserService {
    Map<String, String> getUsers();
    List<UserDTO> findUser(Long buildingId);

}
