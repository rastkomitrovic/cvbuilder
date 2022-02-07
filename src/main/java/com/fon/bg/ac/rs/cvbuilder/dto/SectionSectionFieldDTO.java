package com.fon.bg.ac.rs.cvbuilder.dto;


import java.util.Objects;

public class SectionSectionFieldDTO {

    private SectionDTO section;

    private SectionFieldDTO sectionField;

    private Integer orderNumber;

    public SectionSectionFieldDTO(){

    }

    public SectionSectionFieldDTO(SectionDTO section, SectionFieldDTO sectionField, Integer orderNumber) {
        this.section = section;
        this.sectionField = sectionField;
        this.orderNumber = orderNumber;
    }

    public SectionDTO getSection() {
        return section;
    }

    public void setSection(SectionDTO section) {
        this.section = section;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SectionSectionFieldDTO)) return false;
        SectionSectionFieldDTO that = (SectionSectionFieldDTO) o;
        return Objects.equals(section, that.section) &&
                Objects.equals(sectionField, that.sectionField);
    }

}
