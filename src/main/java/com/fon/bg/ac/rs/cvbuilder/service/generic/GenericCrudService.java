package com.fon.bg.ac.rs.cvbuilder.service.generic;

import com.fon.bg.ac.rs.cvbuilder.mapper.generic.GenericMapper;
import com.fon.bg.ac.rs.cvbuilder.util.CVBuilderException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

// D- DAO class
// T - DTO class
// R - Id class
// S - Repository class
// M - Mapper class
public abstract class GenericCrudService<D, T, R, S extends CrudRepository<D, R>, M extends GenericMapper<D, T>> {

    @Autowired
    protected S repository;

    @Autowired
    protected M mapper;

    public T save(T object) {
        checkPreconditionsForSave(object);
        return mapper.toDTO(repository.save(mapper.toDAO(object)));
    }

    public T update(T object) {
        checkPreconditionsForUpdate(object);
        return mapper.toDTO(repository.save(mapper.toDAO(object)));
    }

    public void delete(R id) {
        repository.deleteById(id);
    }

    public List<T> getAll() {
        return mapper.toDTOList(repository.findAll());
    }

    public Optional<T> findById(R id) {
        return repository.findById(id).map(it -> mapper.toDTO(it));
    }

    protected abstract void checkPreconditionsForSave(T object);

    protected abstract void checkPreconditionsForUpdate(T object);
}
