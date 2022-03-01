package com.fon.bg.ac.rs.cvbuilder.repository;

import com.fon.bg.ac.rs.cvbuilder.entity.SectionField;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectionFieldRepository extends PagingAndSortingRepository<SectionField, Long> {

    @Query("select s from SectionField s where s.name like concat('%',:param,'%')")
    Page<SectionField> searchPage(Pageable pageable, String param);
}
