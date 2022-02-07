package com.fon.bg.ac.rs.cvbuilder.repository;

import com.fon.bg.ac.rs.cvbuilder.entity.CVSectionSectionField;
import com.fon.bg.ac.rs.cvbuilder.entity.embedded.CVSectionSectionFieldEmbeddedId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CVSectionSectionFieldRepository extends CrudRepository<CVSectionSectionField, CVSectionSectionFieldEmbeddedId> {
}
