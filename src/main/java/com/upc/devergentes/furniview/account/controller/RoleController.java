package com.upc.devergentes.furniview.account.controller;

import com.upc.devergentes.furniview.account.dto.RoleDTO;
import com.upc.devergentes.furniview.account.model.domain.Role;
import com.upc.devergentes.furniview.account.model.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/roles")
public class RoleController {

    private final RoleService roleService;

    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping
    public ResponseEntity<List<RoleDTO>> getAllRoles() {
        List<Role> roles = roleService.getAllRoles();
        List<RoleDTO> roleDTOs = roles.stream()
                .map(RoleDTO::fromRole)
                .collect(Collectors.toList());
        return ResponseEntity.ok(roleDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleDTO> getRoleById(@PathVariable Long id) {
        Role role = roleService.getRoleById(id);
        RoleDTO roleDTO = RoleDTO.fromRole(role);
        return ResponseEntity.ok(roleDTO);
    }

    @PostMapping
    public ResponseEntity<RoleDTO> createRole(@RequestBody RoleDTO roleDTO) {
        Role role = roleDTO.toRole();
        Role createdRole = roleService.createRole(role);
        RoleDTO createdRoleDTO = RoleDTO.fromRole(createdRole);
        return ResponseEntity.ok(createdRoleDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoleDTO> updateRole(@PathVariable Long id, @RequestBody RoleDTO roleDTO) {
        Role role = roleDTO.toRole();
        Role updatedRole = roleService.updateRole(id, role);
        RoleDTO updatedRoleDTO = RoleDTO.fromRole(updatedRole);
        return ResponseEntity.ok(updatedRoleDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRole(@PathVariable Long id) {
        roleService.deleteRole(id);
        return ResponseEntity.noContent().build();
    }
}
