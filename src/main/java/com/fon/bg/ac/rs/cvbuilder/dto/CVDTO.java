package com.fon.bg.ac.rs.cvbuilder.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Size;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class CVDTO {

    @NotNull(message = "Id CV-a ne sme biti prazan")
    private Long id;

    @NotNull(message = "Naziv CV-a ne sme biti prazan")
    @Size(min = 3, max = 255, message = "Naziv CV-a mora biti izmedju 3 i 255 karaktera")
    private String name;

    private String description;

    @NotNull(message = "Datum kreiranja ne sme biti prazan")
    @PastOrPresent(message = "Datum kreiranja mora biti ili trenutni datum ili datum u proslosti")
    private Instant dateCreated;

    private Instant dateEdited;

    private TemplateDTO template;

    @NotNull(message = "Korisnik CV-a ne sme biti prazan")
    private UserDTO user;

    @NotNull(message = "Sekcije CV-a ne smeju biti prazne")
    private List<CVSectionDTO> cvSections;

    public CVDTO(){

    }

    public CVDTO(Long id, String name, String description, Instant dateCreated, Instant dateEdited, TemplateDTO template, UserDTO user, List<CVSectionDTO> cvSections) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.dateCreated = dateCreated;
        this.dateEdited = dateEdited;
        this.template = template;
        this.user = user;
        this.cvSections = cvSections;
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

    public Instant getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Instant dateCreated) {
        this.dateCreated = dateCreated;
    }

    public Instant getDateEdited() {
        return dateEdited;
    }

    public void setDateEdited(Instant dateEdited) {
        this.dateEdited = dateEdited;
    }

    public TemplateDTO getTemplate() {
        return template;
    }

    public void setTemplate(TemplateDTO template) {
        this.template = template;
    }

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public List<CVSectionDTO> getCvSections() {
        return cvSections;
    }

    public void setCvSections(List<CVSectionDTO> cvSections) {
        this.cvSections = cvSections;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CVDTO)) return false;
        CVDTO cvdto = (CVDTO) o;
        return Objects.equals(id, cvdto.id);
    }

}
