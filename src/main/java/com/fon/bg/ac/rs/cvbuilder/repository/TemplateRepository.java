package com.fon.bg.ac.rs.cvbuilder.repository;

import com.fon.bg.ac.rs.cvbuilder.entity.Template;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemplateRepository extends PagingAndSortingRepository<Template, Long> {

    @Query("select t from Template t where t.name like concat('%',:param,'%')")
    Page<Template> searchPage(Pageable pageable, String param);
}
