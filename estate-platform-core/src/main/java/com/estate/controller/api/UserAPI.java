package com.estate.controller.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.estate.dto.UserDTO;
import com.estate.service.IUserService;

import java.util.List;

@RestController
@RequestMapping("/api/admin/user")
public class UserAPI {

    @Autowired
    private IUserService userService;

    @GetMapping
    public ResponseEntity<List<UserDTO>> loadUser(@RequestParam(value = "buildingId", required = false) long buildingId) {
        return ResponseEntity.ok(userService.findUser(buildingId));
    }
}
