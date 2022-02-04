package com.fon.bg.ac.rs.cvbuilder.entity;

import com.fon.bg.ac.rs.cvbuilder.entity.embedded.CVSectionSectionFieldEmbeddedId;

import javax.persistence.*;

@Entity
@Table(name = "cvsectionsectionfield")
@AssociationOverrides(
        {
                @AssociationOverride(name = "cvSectionSectionFieldEmbeddedId.cvSection", joinColumns = @JoinColumn(name = "cvsection_id", nullable = false)),
                @AssociationOverride(name = "cvSectionSectionFieldEmbeddedId.sectionField", joinColumns = @JoinColumn(name = "section_field_id", nullable = false))
        }
)
public class CVSectionSectionField {

    @EmbeddedId
    private CVSectionSectionFieldEmbeddedId cvSectionSectionFieldEmbeddedId;
}
