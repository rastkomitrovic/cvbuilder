package com.fon.bg.ac.rs.cvbuilder.service.impl;

import com.fon.bg.ac.rs.cvbuilder.dto.SectionFieldDTO;
import com.fon.bg.ac.rs.cvbuilder.entity.SectionField;
import com.fon.bg.ac.rs.cvbuilder.mapper.SectionFieldMapper;
import com.fon.bg.ac.rs.cvbuilder.repository.SectionFieldRepository;
import com.fon.bg.ac.rs.cvbuilder.service.generic.GenericCrudService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class SectionFieldService implements GenericCrudService<SectionFieldDTO, Long> {

    @Resource
    private SectionFieldRepository repository;

    @Resource
    private SectionFieldMapper mapper;

    @Override
    public SectionFieldDTO save(SectionFieldDTO object) {
        return mapper.toDTO(repository.save(mapper.toDAO(object)));
    }

    @Override
    public SectionFieldDTO update(SectionFieldDTO object) {
        return mapper.toDTO(repository.save(mapper.toDAO(object)));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<SectionFieldDTO> getAll() {
        return mapper.toDTOList(repository.findAll());
    }

    @Override
    public Optional<SectionFieldDTO> findById(Long id) {
        return repository.findById(id).map(it -> mapper.toDTO(it));
    }
}
