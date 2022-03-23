package com.fon.bg.ac.rs.cvbuilder.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Objects;

public class TemplateDTO {

    @NotNull(message = "Id sablona ne sme biti prazan")
    @Min(value = 0, message = "Id sablona mora biti 0 ili vece")
    private Long id;

    @NotNull(message = "Naziv sablona ne sme biti prazan")
    @Size(min = 3,max = 255,message = "Naziv sablona mora imati izmedju 3 i 255 karaktera")
    private String name;

    private String description;

    @NotNull(message = "Vrednost da li je sablon privatan ne sme biti prazno")
    private Boolean privateTemplate;

    @NotNull(message = "Korisnik koji je kreirao sablon ne sme biti prazan")
    private UserDTO user;

    @NotNull(message = "Sekcije sablona ne smeju biti prazne")
    private List<TemplateSectionDTO> templateSections;

    public TemplateDTO(){

    }

    public TemplateDTO(Long id, String name, String description, Boolean privateTemplate, UserDTO user, List<TemplateSectionDTO> templateSections) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.privateTemplate = privateTemplate;
        this.user = user;
        this.templateSections = templateSections;
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

    public Boolean isPrivateTemplate() {
        return privateTemplate;
    }

    public void setPrivateTemplate(Boolean privateTemplate) {
        this.privateTemplate = privateTemplate;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public List<TemplateSectionDTO> getTemplateSections() {
        return templateSections;
    }

    public void setTemplateSections(List<TemplateSectionDTO> templateSections) {
        this.templateSections = templateSections;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TemplateDTO)) return false;
        TemplateDTO that = (TemplateDTO) o;
        return Objects.equals(id, that.id);
    }
}
