package com.fon.bg.ac.rs.cvbuilder.service.impl;

import com.fon.bg.ac.rs.cvbuilder.dto.SectionDTO;
import com.fon.bg.ac.rs.cvbuilder.mapper.SectionMapper;
import com.fon.bg.ac.rs.cvbuilder.repository.SectionRepository;
import com.fon.bg.ac.rs.cvbuilder.service.generic.GenericCrudService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class SectionService implements GenericCrudService<SectionDTO,Long> {

    @Resource
    private SectionRepository repository;

    @Resource
    private SectionMapper mapper;

    @Override
    public SectionDTO save(SectionDTO object) {
        return mapper.toDTO(repository.save(mapper.toDAO(object)));
    }

    @Override
    public SectionDTO update(SectionDTO object) {
        return mapper.toDTO(repository.save(mapper.toDAO(object)));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<SectionDTO> getAll() {
        return mapper.toDTOList(repository.findAll());
    }

    @Override
    public Optional<SectionDTO> findById(Long id) {
        return repository.findById(id).map(it -> mapper.toDTO(it));
    }
}
