package com.estate.controller.api;

import com.estate.dto.BuildingDTO;
import com.estate.service.IBuildingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/admin/building")
public class BuildingAPI {

    @Autowired
    private IBuildingService buildingService;

    @PostMapping
    public ResponseEntity<BuildingDTO> createBuilding(@RequestBody BuildingDTO buildingDTO) {
        return ResponseEntity.ok(buildingService.save(buildingDTO));
    }

    @PutMapping
    public ResponseEntity<BuildingDTO> updateBuilding(@RequestBody BuildingDTO buildingDTO) {
        return ResponseEntity.ok(buildingService.update(buildingDTO));
    }

    @DeleteMapping
    public ResponseEntity<Void> deleteBuilding(@RequestBody long[] id) {
        buildingService.deleteBuilding(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/users")
    public ResponseEntity<Void> assignUserToBuilding(@PathVariable("id") long id, @RequestBody long[] users) {
        buildingService.assignUserToBuilding(users, id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/{id}/priority")
    public ResponseEntity<Void> updateBuildingPriority(@PathVariable("id") long id, @RequestParam(value = "action", required = false) String action) {
        buildingService.updatePriority(action, id);
        return ResponseEntity.noContent().build();
    }
}
