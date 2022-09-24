package com.fon.bg.ac.rs.cvbuilder.service.generic;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

// D- DAO class
// T - DTO class
// R - Id class
// S - Repository class
// M - Mapper class
public abstract class GenericPagingService<D, T, R, S extends PagingAndSortingRepository<D, R>, M extends GenericMapper<D, T>> extends GenericCrudService<D, T, R, S, M> {

    public Page<T> findPage(Pageable pageable) {
        return repository.findAll(pageable).map(it -> mapper.toDTO(it));
    }

    abstract public Page<T> searchPage(Pageable pageable, String searchParam);
}
