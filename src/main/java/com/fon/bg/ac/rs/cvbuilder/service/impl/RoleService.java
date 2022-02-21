package com.fon.bg.ac.rs.cvbuilder.service.impl;

import com.fon.bg.ac.rs.cvbuilder.dto.RoleDTO;
import com.fon.bg.ac.rs.cvbuilder.mapper.RoleMapper;
import com.fon.bg.ac.rs.cvbuilder.repository.RoleRepository;
import com.fon.bg.ac.rs.cvbuilder.service.generic.GenericCrudService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class RoleService implements GenericCrudService<RoleDTO,Long> {

    @Resource
    private RoleRepository repository;

    @Resource
    private RoleMapper mapper;

    @Override
    public RoleDTO save(RoleDTO object) {
        return mapper.toDTO(repository.save(mapper.toDAO(object)));
    }

    @Override
    public RoleDTO update(RoleDTO object) {
        return mapper.toDTO(repository.save(mapper.toDAO(object)));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<RoleDTO> getAll() {
        return mapper.toDTOList(repository.findAll());
    }

    @Override
    public Optional<RoleDTO> findById(Long id) {
        return repository.findById(id).map(it -> mapper.toDTO(it));
    }
}
