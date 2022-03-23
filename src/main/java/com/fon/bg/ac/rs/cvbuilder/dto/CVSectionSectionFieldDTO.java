package com.fon.bg.ac.rs.cvbuilder.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public class CVSectionSectionFieldDTO {

    @JsonBackReference
    private CVSectionDTO cvSection;

    @NotNull(message = "Polje sekcije u polju sekcije CV-a ne sme biti prazan")
    private SectionFieldDTO sectionField;

    @NotNull(message = "Redni broj polja sekcije CV-a ne sme biti prazan")
    @Min(value = 1,message = "Redni broj sekcije u CV-u mora biti 1 ili veci")
    private Integer orderNumber;

    private String stringValue;

    private Long numberValue;

    private Double doubleValue;

    private LocalDate dateValue;

    private LocalDateTime dateTimeValue;

    private byte[] blobValue;

    public CVSectionSectionFieldDTO(){

    }

    public CVSectionSectionFieldDTO(CVSectionDTO cvSection, SectionFieldDTO sectionField, Integer orderNumber, String stringValue, Long numberValue, Double doubleValue, LocalDate dateValue, LocalDateTime dateTimeValue, byte[] blobValue) {
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

    public CVSectionDTO getCvSection() {
        return cvSection;
    }

    public void setCvSection(CVSectionDTO cvSection) {
        this.cvSection = cvSection;
    }

    public SectionFieldDTO getSectionField() {
        return sectionField;
    }

    public void setSectionField(SectionFieldDTO sectionField) {
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
        if (!(o instanceof CVSectionSectionFieldDTO)) return false;
        CVSectionSectionFieldDTO that = (CVSectionSectionFieldDTO) o;
        return Objects.equals(cvSection, that.cvSection) &&
                Objects.equals(sectionField, that.sectionField);
    }

}
