package com.estate.service.impl;

import com.estate.repository.DistrictRepository;
import com.estate.service.IDistrictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class DistrictService implements IDistrictService {

    @Autowired
    private DistrictRepository districtRepository;

    @Override
    public Map<String, String> getDistricts() {
        Map<String, String> results = new HashMap<>();
        districtRepository.findAll().forEach(item -> results.put(item.getCode(), item.getName()));
        return results;
    }
}
