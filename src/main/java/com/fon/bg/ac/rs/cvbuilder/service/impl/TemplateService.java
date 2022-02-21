package com.fon.bg.ac.rs.cvbuilder.service.impl;

import com.fon.bg.ac.rs.cvbuilder.dto.TemplateDTO;
import com.fon.bg.ac.rs.cvbuilder.mapper.TemplateMapper;
import com.fon.bg.ac.rs.cvbuilder.repository.TemplateRepository;
import com.fon.bg.ac.rs.cvbuilder.service.generic.GenericPagingService;
import com.fon.bg.ac.rs.cvbuilder.util.SearchParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class TemplateService implements GenericPagingService<TemplateDTO,Long> {

    @Resource
    private TemplateRepository repository;

    @Resource
    private TemplateMapper mapper;

    @Override
    public Page<TemplateDTO> findPage(Pageable pageable) {
        return repository.findAll(pageable).map(it -> mapper.toDTO(it));
    }

    @Override
    public Page<TemplateDTO> searchPage(Pageable pageable, List<SearchParam> searchParams) {
        return null;
    }

    @Override
    public TemplateDTO save(TemplateDTO object) {
        return mapper.toDTO(repository.save(mapper.toDAO(object)));
    }

    @Override
    public TemplateDTO update(TemplateDTO object) {
        return mapper.toDTO(repository.save(mapper.toDAO(object)));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<TemplateDTO> getAll() {
        return mapper.toDTOList(repository.findAll());
    }

    @Override
    public Optional<TemplateDTO> findById(Long id) {
        return repository.findById(id).map(it -> mapper.toDTO(it));
    }
}
