package com.fon.bg.ac.rs.cvbuilder.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

public class RoleDTO {

    @NotNull(message = "Id role ne sme biti prazan")
    private Long id;

    @NotNull(message = "Naziv role ne sme biti prazan")
    @Size(min = 3, max = 255, message = "Naziv role mora biti izmedju 3 i 255 karaktera")
    private String name;

    public RoleDTO(){

    }

    public RoleDTO(Long id, String name) {
        this.id = id;
        this.name = name;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof RoleDTO)) return false;
        RoleDTO roleDTO = (RoleDTO) o;
        return Objects.equals(id, roleDTO.id);
    }

}
