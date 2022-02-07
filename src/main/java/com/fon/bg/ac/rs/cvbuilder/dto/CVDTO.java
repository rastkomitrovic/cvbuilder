package com.fon.bg.ac.rs.cvbuilder.dto;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class CVDTO {

    private Long id;

    private String name;

    private String description;

    private LocalDateTime dateCreated;

    private LocalDateTime dateEdited;

    private TemplateDTO template;

    private UserDTO user;

    private List<CVSectionDTO> cvSections;

    public CVDTO(){

    }

    public CVDTO(Long id, String name, String description, LocalDateTime dateCreated, LocalDateTime dateEdited, TemplateDTO template, UserDTO user, List<CVSectionDTO> cvSections) {
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

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDateTime getDateEdited() {
        return dateEdited;
    }

    public void setDateEdited(LocalDateTime dateEdited) {
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
