package com.upc.devergentes.furniview.account.controller;


import com.upc.devergentes.furniview.account.dto.UserSystemDTO;
import com.upc.devergentes.furniview.account.model.domain.UserSystem;
import com.upc.devergentes.furniview.account.model.service.UserSystemService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/accounts")
public class UserSystemController {
    private final UserSystemService userSystemService;

    public UserSystemController(UserSystemService userSystemService) {
        this.userSystemService = userSystemService;
    }

    @GetMapping
    public ResponseEntity<List<UserSystemDTO>> getAllUserSystems() {
        List<UserSystem> userSystems = userSystemService.getAllUserSystems();
        List<UserSystemDTO> userSystemDTOs = userSystems.stream()
                .map(UserSystemDTO::fromUserSystem)
                .collect(Collectors.toList());
        return ResponseEntity.ok(userSystemDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserSystemDTO> getUserSystemById(@PathVariable Long id) {
        UserSystem userSystem = userSystemService.getUserSystemById(id);
        UserSystemDTO userSystemDTO = UserSystemDTO.fromUserSystem(userSystem);
        return ResponseEntity.ok(userSystemDTO);
    }

    @PostMapping
    public ResponseEntity<UserSystemDTO> createUserSystem(@RequestBody UserSystemDTO userSystemDTO) {
        UserSystem userSystem = userSystemDTO.toUserSystem();
        UserSystem createdUserSystem = userSystemService.createUserSystem(userSystem);
        UserSystemDTO createdUserSystemDTO = UserSystemDTO.fromUserSystem(createdUserSystem);
        return ResponseEntity.ok(createdUserSystemDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserSystemDTO> updateUserSystem(@PathVariable Long id, @RequestBody UserSystemDTO userSystemDTO) {
        UserSystem userSystem = userSystemDTO.toUserSystem();
        UserSystem updatedUserSystem = userSystemService.updateUserSystem(id, userSystem);
        UserSystemDTO updatedUserSystemDTO = UserSystemDTO.fromUserSystem(updatedUserSystem);
        return ResponseEntity.ok(updatedUserSystemDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUserSystem(@PathVariable Long id) {
        userSystemService.deleteUserSystem(id);
        return ResponseEntity.noContent().build();
    }

}
