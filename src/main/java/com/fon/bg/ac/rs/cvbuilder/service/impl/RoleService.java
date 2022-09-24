package com.fon.bg.ac.rs.cvbuilder.service.impl;

import com.fon.bg.ac.rs.cvbuilder.dto.RoleDTO;
import com.fon.bg.ac.rs.cvbuilder.mapper.RoleMapper;
import com.fon.bg.ac.rs.cvbuilder.repository.RoleRepository;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class RoleService {

    @Resource
    private RoleRepository roleRepository;

    @Resource
    private RoleMapper roleMapper;

    public List<RoleDTO> getAllRoles() {
        return roleMapper.toRoleDTOS(roleRepository.findAll());
    }
}
