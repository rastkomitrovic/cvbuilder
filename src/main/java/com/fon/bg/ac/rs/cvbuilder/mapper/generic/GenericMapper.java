package com.fon.bg.ac.rs.cvbuilder.mapper.generic;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;

// T - DAO class
// R - DTO class
public abstract class GenericMapper<T,R> {
    public R toDTO(T object){
        if(object == null)
            return null;
        return toDTOTransformation(object);
    }
    public T toDAO(R object){
        if(object == null)
            return null;
        return toDAOTransformation(object);
    }
    public List<R> toDTOList(Iterable<T> list){
        if(list == null)
            return null;
        List<R> listDTO = new LinkedList<>();
        list.forEach(value -> listDTO.add(toDTO(value)));
        return listDTO;
    }

    protected abstract R toDTOTransformation(T object);
    protected abstract T toDAOTransformation(R object);

    Function<T,R> toDTOFunction(){
        return this::toDTO;
    }
}
