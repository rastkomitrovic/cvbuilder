package com.fon.bg.ac.rs.cvbuilder.mapper;

import com.fon.bg.ac.rs.cvbuilder.dto.RoleDTO;
import com.fon.bg.ac.rs.cvbuilder.entity.Role;
import com.fon.bg.ac.rs.cvbuilder.mapper.generic.GenericMapper;
import org.springframework.stereotype.Service;

@Service
public class RoleMapper extends GenericMapper<Role, RoleDTO> {

    @Override
    protected RoleDTO toDTOTransformation(Role object) {
        if(object == null)
            return null;
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setId(object.getId());
        roleDTO.setName(object.getName());
        return roleDTO;
    }

    @Override
    protected Role toDAOTransformation(RoleDTO object) {
        if(object == null)
            return null;
        Role role = new Role();
        role.setId(object.getId());
        role.setName(object.getName());
        return role;
    }

}
