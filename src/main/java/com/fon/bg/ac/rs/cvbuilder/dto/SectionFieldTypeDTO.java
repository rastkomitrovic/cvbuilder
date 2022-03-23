package com.fon.bg.ac.rs.cvbuilder.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

public class SectionFieldTypeDTO {

    @NotNull(message = "Id tipa polja sekcije ne sme biti prazan")
    @Min(value = 0, message = "Id tipa polja sekcije mora biti 0 ili vece")
    private Long id;

    @NotNull(message = "Naziv tipa polja sekcije ne sme biti prazan")
    @Size(min = 3, max = 255, message = "Naziv tipa polja sekcije mora imati izmedju 3 i 255 karaktera")
    private String name;

    @NotNull(message = "Kljuc tipa polja ne sme biti prazan")
    @Size(min = 3,max = 255,message = "Kljuc tipa polja mora imati izmedju 3 i 255 karaktera")
    private String keyValue;

    private String description;

    public SectionFieldTypeDTO(){

    }

    public SectionFieldTypeDTO(Long id, String name, String keyValue, String description) {
        this.id = id;
        this.name = name;
        this.keyValue = keyValue;
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

    public String getKeyValue() {
        return keyValue;
    }

    public void setKeyValue(String keyValue) {
        this.keyValue = keyValue;
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
