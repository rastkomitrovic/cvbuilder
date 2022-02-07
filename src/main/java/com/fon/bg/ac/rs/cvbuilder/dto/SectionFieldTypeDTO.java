package com.fon.bg.ac.rs.cvbuilder.dto;

import java.util.Objects;

public class SectionFieldTypeDTO {

    private Long id;

    private String name;

    private String description;

    public SectionFieldTypeDTO(){

    }

    public SectionFieldTypeDTO(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SectionFieldTypeDTO)) return false;
        SectionFieldTypeDTO that = (SectionFieldTypeDTO) o;
        return Objects.equals(id, that.id);
    }

}
