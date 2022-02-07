package com.fon.bg.ac.rs.cvbuilder.dto;

import java.util.Objects;

public class SectionFieldDTO {

    private Long id;

    private String name;

    private String description;

    private SectionFieldTypeDTO sectionFieldType;

    public SectionFieldDTO(){

    }

    public SectionFieldDTO(Long id, String name, String description, SectionFieldTypeDTO sectionFieldType) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.sectionFieldType = sectionFieldType;
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

    public SectionFieldTypeDTO getSectionFieldType() {
        return sectionFieldType;
    }

    public void setSectionFieldType(SectionFieldTypeDTO sectionFieldType) {
        this.sectionFieldType = sectionFieldType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SectionFieldDTO)) return false;
        SectionFieldDTO that = (SectionFieldDTO) o;
        return Objects.equals(id, that.id);
    }

}
