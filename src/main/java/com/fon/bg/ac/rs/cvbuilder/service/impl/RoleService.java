package com.fon.bg.ac.rs.cvbuilder.service.impl;

import com.fon.bg.ac.rs.cvbuilder.dto.RoleDTO;
import com.fon.bg.ac.rs.cvbuilder.entity.Role;
import com.fon.bg.ac.rs.cvbuilder.mapper.RoleMapper;
import com.fon.bg.ac.rs.cvbuilder.repository.RoleRepository;
import com.fon.bg.ac.rs.cvbuilder.service.generic.GenericCrudService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class RoleService extends GenericCrudService<Role,RoleDTO,Long,RoleRepository,RoleMapper> {

    @Override
    protected void checkPreconditionsForSave(RoleDTO object) {

    }

    @Override
    protected void checkPreconditionsForUpdate(RoleDTO object) {

    }
}
