package com.fon.bg.ac.rs.cvbuilder.entity;

import com.fon.bg.ac.rs.cvbuilder.entity.abs.BaseEntity;
import com.fon.bg.ac.rs.cvbuilder.entity.embedded.CVSectionSectionFieldEmbeddedId;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

@Entity
@Table(name = "cvsectionsectionfield")
/*@AssociationOverrides(
        {
                @AssociationOverride(name = "cvSectionSectionFieldEmbeddedId.cvSectionId", joinColumns = @JoinColumn(name = "cvsection_id", nullable = false)),
                @AssociationOverride(name = "cvSectionSectionFieldEmbeddedId.sectionFieldId", joinColumns = @JoinColumn(name = "section_field_id", nullable = false))
        }
)*/
public class CVSectionSectionField extends BaseEntity {

    @EmbeddedId
    private CVSectionSectionFieldEmbeddedId cvSectionSectionFieldEmbeddedId;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @MapsId("cvSectionId")
    @JoinColumn(name = "cvsection_id", insertable = false, updatable = false)
    private CVSection cvSection;

    @ManyToOne(fetch = FetchType.EAGER)
    @MapsId("sectionFieldId")
    @JoinColumn(name = "section_field_id", insertable = false, updatable = false)
    private SectionField sectionField;

    @Column(name = "order_number", nullable = false)
    private Integer orderNumber;

    @Column(name = "string_value", nullable = true)
    private String stringValue;

    @Column(name = "number_value", nullable = true)
    private Long numberValue;

    @Column(name = "double_value", nullable = true)
    private Double doubleValue;

    @Basic
    @Column(name = "date_value",nullable = true)
    private LocalDate dateValue;

    @Basic
    @Column(name = "date_time_value", nullable = true)
    private LocalDateTime dateTimeValue;

    @Lob
    @Column(name = "blob_value", columnDefinition = "BLOB")
    private byte[] blobValue;

    public CVSectionSectionField(){

    }

    public CVSectionSectionField(CVSectionSectionFieldEmbeddedId cvSectionSectionFieldEmbeddedId, CVSection cvSection, SectionField sectionField, Integer orderNumber, String stringValue, Long numberValue, Double doubleValue, LocalDate dateValue, LocalDateTime dateTimeValue, byte[] blobValue) {
        this.cvSectionSectionFieldEmbeddedId = cvSectionSectionFieldEmbeddedId;
        this.cvSection = cvSection;
        this.sectionField = sectionField;
        this.orderNumber = orderNumber;
        this.stringValue = stringValue;
        this.numberValue = numberValue;
        this.doubleValue = doubleValue;
        this.dateValue = dateValue;
        this.dateTimeValue = dateTimeValue;
        this.blobValue = blobValue;
    }

    public CVSectionSectionFieldEmbeddedId getCvSectionSectionFieldEmbeddedId() {
        return cvSectionSectionFieldEmbeddedId;
    }

    public void setCvSectionSectionFieldEmbeddedId(CVSectionSectionFieldEmbeddedId cvSectionSectionFieldEmbeddedId) {
        this.cvSectionSectionFieldEmbeddedId = cvSectionSectionFieldEmbeddedId;
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

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public String getStringValue() {
        return stringValue;
    }

    public void setStringValue(String stringValue) {
        this.stringValue = stringValue;
    }

    public Long getNumberValue() {
        return numberValue;
    }

    public void setNumberValue(Long numberValue) {
        this.numberValue = numberValue;
    }

    public Double getDoubleValue() {
        return doubleValue;
    }

    public void setDoubleValue(Double doubleValue) {
        this.doubleValue = doubleValue;
    }

    public LocalDate getDateValue() {
        return dateValue;
    }

    public void setDateValue(LocalDate dateValue) {
        this.dateValue = dateValue;
    }

    public LocalDateTime getDateTimeValue() {
        return dateTimeValue;
    }

    public void setDateTimeValue(LocalDateTime dateTimeValue) {
        this.dateTimeValue = dateTimeValue;
    }

    public byte[] getBlobValue() {
        return blobValue;
    }

    public void setBlobValue(byte[] blobValue) {
        this.blobValue = blobValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CVSectionSectionField)) return false;
        CVSectionSectionField that = (CVSectionSectionField) o;
        return Objects.equals(cvSectionSectionFieldEmbeddedId, that.cvSectionSectionFieldEmbeddedId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cvSectionSectionFieldEmbeddedId);
    }
}
