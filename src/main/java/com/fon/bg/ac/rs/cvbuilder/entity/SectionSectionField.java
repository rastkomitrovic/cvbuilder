package com.fon.bg.ac.rs.cvbuilder.entity;

import com.fon.bg.ac.rs.cvbuilder.entity.embedded.SectionSectionFieldEmbeddedId;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "sectionsectionfield")
@AssociationOverrides(
        {
                @AssociationOverride(name = "sectionSectionFieldEmbeddedId.section", joinColumns = @JoinColumn(name = "section_id", nullable = false)),
                @AssociationOverride(name = "sectionSectionFieldEmbeddedId.sectionField", joinColumns = @JoinColumn(name = "section_field_id", nullable = false))
        }
)
public class SectionSectionField {

    @EmbeddedId
    @Fetch(value = FetchMode.JOIN)
    private SectionSectionFieldEmbeddedId sectionSectionFieldEmbeddedId;

    @Column(name = "order_number", nullable = false)
    private Integer orderNumber;

    public SectionSectionField() {

    }

    public SectionSectionField(SectionSectionFieldEmbeddedId sectionSectionFieldEmbeddedId, Integer orderNumber) {
        this.sectionSectionFieldEmbeddedId = sectionSectionFieldEmbeddedId;
        this.orderNumber = orderNumber;
    }

    public SectionSectionFieldEmbeddedId getSectionSectionFieldEmbeddedId() {
        return sectionSectionFieldEmbeddedId;
    }

    public void setSectionSectionFieldEmbeddedId(SectionSectionFieldEmbeddedId sectionSectionFieldEmbeddedId) {
        this.sectionSectionFieldEmbeddedId = sectionSectionFieldEmbeddedId;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    @Transient
    public Section getSection() {
        return sectionSectionFieldEmbeddedId.getSection();
    }

    @Transient
    public SectionField getSectionField() {
        return sectionSectionFieldEmbeddedId.getSectionField();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SectionSectionField)) return false;
        SectionSectionField that = (SectionSectionField) o;
        return Objects.equals(sectionSectionFieldEmbeddedId, that.sectionSectionFieldEmbeddedId);
    }

}
