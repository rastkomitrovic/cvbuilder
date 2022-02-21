package com.fon.bg.ac.rs.cvbuilder.service.impl;

import com.fon.bg.ac.rs.cvbuilder.dto.CVDTO;
import com.fon.bg.ac.rs.cvbuilder.mapper.CVMapper;
import com.fon.bg.ac.rs.cvbuilder.repository.CVRepository;
import com.fon.bg.ac.rs.cvbuilder.service.generic.GenericPagingService;
import com.fon.bg.ac.rs.cvbuilder.util.SearchParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class CVService implements GenericPagingService<CVDTO,Long> {

    @Resource
    private CVRepository repository;

    @Resource
    private CVMapper mapper;

    @Override
    public Page<CVDTO> findPage(Pageable pageable) {
        return repository.findAll(pageable).map(it -> mapper.toDTO(it));
    }

    @Override
    public Page<CVDTO> searchPage(Pageable pageable, List<SearchParam> searchParams) {
        return null;
    }

    @Override
    public CVDTO save(CVDTO object) {
        return mapper.toDTO(repository.save(mapper.toDAO(object)));
    }

    @Override
    public CVDTO update(CVDTO object) {
        return mapper.toDTO(repository.save(mapper.toDAO(object)));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<CVDTO> getAll() {
        return mapper.toDTOList(repository.findAll());
    }

    @Override
    public Optional<CVDTO> findById(Long id) {
        return repository.findById(id).map(it -> mapper.toDTO(it));
    }
}
