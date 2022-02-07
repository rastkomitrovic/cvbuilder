package com.fon.bg.ac.rs.cvbuilder.repository;

import com.fon.bg.ac.rs.cvbuilder.entity.SectionSectionField;
import com.fon.bg.ac.rs.cvbuilder.entity.embedded.SectionSectionFieldEmbeddedId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SectionSectionFieldRepository extends CrudRepository<SectionSectionField, SectionSectionFieldEmbeddedId> {
}
