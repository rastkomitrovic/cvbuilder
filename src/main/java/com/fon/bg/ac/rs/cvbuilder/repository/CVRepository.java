package com.fon.bg.ac.rs.cvbuilder.repository;

import com.fon.bg.ac.rs.cvbuilder.entity.CV;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CVRepository extends PagingAndSortingRepository<CV, Long> {

    @Query("Select c from CV c where c.name like concat('%',:param,'%')")
    Page<CV> searchPage(Pageable pageable, String param);
}
