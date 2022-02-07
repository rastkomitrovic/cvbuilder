package com.fon.bg.ac.rs.cvbuilder.entity.embedded;

import com.fon.bg.ac.rs.cvbuilder.entity.CVSection;
import com.fon.bg.ac.rs.cvbuilder.entity.SectionField;
import com.fon.bg.ac.rs.cvbuilder.entity.abs.BaseEntity;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class CVSectionSectionFieldEmbeddedId extends BaseEntity implements Serializable {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cvsection_id",nullable = false)
    private CVSection cvSection;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "section_field_id", nullable = false)
    private SectionField sectionField;
}
