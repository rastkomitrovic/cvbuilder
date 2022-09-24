package com.fon.bg.ac.rs.cvbuilder.mapper;

import com.fon.bg.ac.rs.cvbuilder.dto.RoleDTO;
import com.fon.bg.ac.rs.cvbuilder.entity.Role;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Service
public class RoleMapper {

    public List<RoleDTO> toRoleDTOS(Iterable<Role> roles) {
        if (roles == null || !roles.iterator().hasNext())
            return Collections.emptyList();

        List<RoleDTO> roleDTOS = new LinkedList<>();
        roles.forEach(role -> roleDTOS.add(toRoleDTO(role)));
        return roleDTOS;
    }

    public RoleDTO toRoleDTO(Role role) {
        if (role == null)
            return null;
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setId(role.getId());
        roleDTO.setName(role.getName());
        return roleDTO;
    }

    public Role toDAO(RoleDTO roleDTO) {
        Role role = new Role();
        role.setId(roleDTO.getId());
        role.setName(roleDTO.getName());
        return role;
    }
}
