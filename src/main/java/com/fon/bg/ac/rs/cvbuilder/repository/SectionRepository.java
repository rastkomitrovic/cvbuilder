package com.fon.bg.ac.rs.cvbuilder.repository;

import com.fon.bg.ac.rs.cvbuilder.entity.Section;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SectionRepository extends PagingAndSortingRepository<Section, Long> {

    @Query("select s from Section s where s.name like concat('%',:param,'%')")
    Page<Section> searchPage(Pageable pageable, String param);

    boolean existsByName(String name);

    boolean existsByNameAndIdNot(String name, Long id);

    @Override
    @EntityGraph(
            type = EntityGraph.EntityGraphType.FETCH,
            attributePaths = {"sectionSectionFields","sectionSectionFields.sectionSectionFieldEmbeddedId.sectionField.sectionFieldType"}
    )
    @Query("select s from Section s where s.id = :aLong")
    Optional<Section> findById(Long aLong);
}
