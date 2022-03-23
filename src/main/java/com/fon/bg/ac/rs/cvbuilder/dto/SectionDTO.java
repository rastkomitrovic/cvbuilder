package com.fon.bg.ac.rs.cvbuilder.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Objects;

public class SectionDTO {

    @NotNull(message = "Id sekcije ne sme biti prazan")
    @Min(value = 0, message = "Id sekcije mora biti 0 ili vece")
    private Long id;

    @NotNull(message = "Naziv sekcije ne sme biti prazan")
    @Size(min = 3, max = 255, message = "Naziv sekcije mora imati izmedju 3 i 255 karaktera")
    private String name;

    private String description;

    @NotNull(message = "Polja sekcije ne smeju biti prazna")
    private List<SectionSectionFieldDTO> sectionSectionFields;

    public SectionDTO(){

    }

    public SectionDTO(Long id, String name, String description, List<SectionSectionFieldDTO> sectionSectionFields) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.sectionSectionFields = sectionSectionFields;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<SectionSectionFieldDTO> getSectionSectionFields() {
        return sectionSectionFields;
    }

    public void setSectionSectionFields(List<SectionSectionFieldDTO> sectionSectionFields) {
        this.sectionSectionFields = sectionSectionFields;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SectionDTO)) return false;
        SectionDTO that = (SectionDTO) o;
        return Objects.equals(id, that.id);
    }

}
