package com.fon.bg.ac.rs.cvbuilder.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Objects;

public class CVSectionDTO {

    @NotNull(message = "Id sekcije u CV-u ne sme biti prazna")
    @Min(value = 0, message = "Id sekcije u CV-u mora biti 0 ili vece")
    private Long id;

    @JsonBackReference
    private CVDTO cv;

    @NotNull(message = "Sekcija u sekciji CV-a ne sme biti prazna")
    private SectionDTO section;

    @NotNull(message = "Redni broj sekcije u CV-u ne sme biti null")
    @Min(value = 1,message = "Redni broj sekcije u CV-u mora biti 1 ili veci")
    private Integer orderNumber;

    @NotNull(message = "Polja u sekciji CV-a ne smeju biti null")
    private List<CVSectionSectionFieldDTO> cvSectionSectionFields;

    public CVSectionDTO(){

    }

    public CVSectionDTO(Long id, CVDTO cv, SectionDTO section, Integer orderNumber, List<CVSectionSectionFieldDTO> cvSectionSectionFields) {
        this.id = id;
        this.cv = cv;
        this.section = section;
        this.orderNumber = orderNumber;
        this.cvSectionSectionFields = cvSectionSectionFields;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CVDTO getCv() {
        return cv;
    }

    public void setCv(CVDTO cv) {
        this.cv = cv;
    }

    public SectionDTO getSection() {
        return section;
    }

    public void setSection(SectionDTO section) {
        this.section = section;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public List<CVSectionSectionFieldDTO> getCvSectionSectionFields() {
        return cvSectionSectionFields;
    }

    public void setCvSectionSectionFields(List<CVSectionSectionFieldDTO> cvSectionSectionFields) {
        this.cvSectionSectionFields = cvSectionSectionFields;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CVSectionDTO)) return false;
        CVSectionDTO that = (CVSectionDTO) o;
        return Objects.equals(id, that.id);
    }

}
