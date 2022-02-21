package com.fon.bg.ac.rs.cvbuilder.service.impl;

import com.fon.bg.ac.rs.cvbuilder.dto.SectionFieldTypeDTO;
import com.fon.bg.ac.rs.cvbuilder.entity.SectionFieldType;
import com.fon.bg.ac.rs.cvbuilder.mapper.SectionFieldTypeMapper;
import com.fon.bg.ac.rs.cvbuilder.repository.SectionFieldTypeRepository;
import com.fon.bg.ac.rs.cvbuilder.service.generic.GenericCrudService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
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
        repository.deleteById(id);
    }

    @Override
    public List<SectionFieldTypeDTO> getAll() {
        return mapper.toDTOList(repository.findAll());
    }

    @Override
    public Optional<SectionFieldTypeDTO> findById(Long id) {
        return repository.findById(id).map(it -> mapper.toDTO(it));
    }
}
