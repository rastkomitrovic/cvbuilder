package com.fon.bg.ac.rs.cvbuilder.service.generic;

import java.util.List;
import java.util.Optional;

public interface GenericCrudService<T,R> {
    T save(T object);
    T update(T object);
    void delete(R id);
    List<T> getAll();
    Optional<T> findById(R id);
}
