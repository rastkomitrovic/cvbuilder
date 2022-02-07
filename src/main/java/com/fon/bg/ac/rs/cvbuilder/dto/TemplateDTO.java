package com.fon.bg.ac.rs.cvbuilder.dto;

import java.util.List;
import java.util.Objects;

public class TemplateDTO {

    private Long id;

    private String name;

    private String description;

    private Boolean privateTemplate;

    private UserDTO user;

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

    public Boolean getPrivateTemplate() {
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
