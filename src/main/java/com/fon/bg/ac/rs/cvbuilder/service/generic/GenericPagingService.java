package com.fon.bg.ac.rs.cvbuilder.service.generic;

import com.fon.bg.ac.rs.cvbuilder.util.SearchParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface GenericPagingService<T,R> extends GenericCrudService<T,R> {
    Page<T> findPage(Pageable pageable);
    Page<T> searchPage(Pageable pageable, List<SearchParam> searchParams);
}
