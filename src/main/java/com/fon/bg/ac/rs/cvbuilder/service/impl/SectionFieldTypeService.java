package com.fon.bg.ac.rs.cvbuilder.service.impl;

import com.fon.bg.ac.rs.cvbuilder.dto.SectionFieldTypeDTO;
import com.fon.bg.ac.rs.cvbuilder.mapper.SectionFieldTypeMapper;
import com.fon.bg.ac.rs.cvbuilder.repository.SectionFieldTypeRepository;
import com.fon.bg.ac.rs.cvbuilder.service.generic.GenericCrudService;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;


public class SectionFieldTypeService implements GenericCrudService<SectionFieldTypeDTO,Long> {

    @Resource
    private SectionFieldTypeRepository repository;

    @Resource
    private SectionFieldTypeMapper mapper;

    @Override
    public SectionFieldTypeDTO save(SectionFieldTypeDTO object) {
        return mapper.toDTO(repository.save(mapper.toDAO(object)));
    }

    @Override
    public SectionFieldTypeDTO update(SectionFieldTypeDTO object) {
        return mapper.toDTO(repository.save(mapper.toDAO(object)));
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public List<SectionFieldTypeDTO> getAll() {
        return null;
    }

    @Override
    public Optional<SectionFieldTypeDTO> findById(Long id) {
        return Optional.empty();
    }
}
