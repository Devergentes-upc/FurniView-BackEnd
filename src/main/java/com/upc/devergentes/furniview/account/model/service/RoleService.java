package com.upc.devergentes.furniview.account.model.service;

import com.upc.devergentes.furniview.account.model.domain.Role;

import java.util.List;

public interface RoleService {
    List<Role> getAllRoles();

    Role getRoleById(Long id);

    Role createRole(Role role);

    Role updateRole(Long id, Role role);

    void deleteRole(Long id);

}
