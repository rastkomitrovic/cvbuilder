package com.fon.bg.ac.rs.cvbuilder.entity.embedded;

import com.fon.bg.ac.rs.cvbuilder.entity.CVSection;
import com.fon.bg.ac.rs.cvbuilder.entity.SectionField;
import com.fon.bg.ac.rs.cvbuilder.entity.abs.BaseEntity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class CVSectionSectionFieldEmbeddedId extends BaseEntity implements Serializable {

    @Column(name = "cvsection_id", nullable = false)
    private Long cvSectionId;

    @Column(name = "section_field_id", nullable = false)
    private Long sectionFieldId;

    public CVSectionSectionFieldEmbeddedId(){

    }

    public CVSectionSectionFieldEmbeddedId(Long cvSectionId, Long sectionFieldId){
        this.cvSectionId = cvSectionId;
        this.sectionFieldId = sectionFieldId;
    }

    public Long getCvSectionId() {
        return cvSectionId;
    }

    public void setCvSectionId(Long cvSectionId) {
        this.cvSectionId = cvSectionId;
    }

    public Long getSectionFieldId() {
        return sectionFieldId;
    }

    public void setSectionFieldId(Long sectionFieldId) {
        this.sectionFieldId = sectionFieldId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CVSectionSectionFieldEmbeddedId)) return false;
        CVSectionSectionFieldEmbeddedId that = (CVSectionSectionFieldEmbeddedId) o;
        return Objects.equals(cvSectionId, that.cvSectionId) && Objects.equals(sectionFieldId, that.sectionFieldId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cvSectionId, sectionFieldId);
    }

    /*@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "cvsection_id",nullable = false)
    private CVSection cvSection;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "section_field_id", nullable = false)
    private SectionField sectionField;

    public CVSectionSectionFieldEmbeddedId() {
    }

    public CVSectionSectionFieldEmbeddedId(CVSection cvSection, SectionField sectionField) {
        this.cvSection = cvSection;
        this.sectionField = sectionField;
    }

    public CVSection getCvSection() {
        return cvSection;
    }

    public void setCvSection(CVSection cvSection) {
        this.cvSection = cvSection;
    }

    public SectionField getSectionField() {
        return sectionField;
    }

    public void setSectionField(SectionField sectionField) {
        this.sectionField = sectionField;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CVSectionSectionFieldEmbeddedId)) return false;
        CVSectionSectionFieldEmbeddedId that = (CVSectionSectionFieldEmbeddedId) o;
        return Objects.equals(cvSection, that.cvSection) &&
                Objects.equals(sectionField, that.sectionField);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cvSection, sectionField);
    }*/
}
