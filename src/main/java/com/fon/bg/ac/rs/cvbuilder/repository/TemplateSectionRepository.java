package com.fon.bg.ac.rs.cvbuilder.repository;

import com.fon.bg.ac.rs.cvbuilder.entity.TemplateSection;
import com.fon.bg.ac.rs.cvbuilder.entity.embedded.TemplateSectionEmbeddedId;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TemplateSectionRepository extends CrudRepository<TemplateSection, TemplateSectionEmbeddedId> {
}
