package com.fon.bg.ac.rs.cvbuilder.dto;

import java.util.Objects;

public class TemplateSectionDTO {

    private TemplateDTO template;

    private SectionDTO section;

    private Boolean repeatable;

    public TemplateSectionDTO(){

    }

    public TemplateSectionDTO(TemplateDTO template, SectionDTO section, Boolean repeatable) {
        this.template = template;
        this.section = section;
        this.repeatable = repeatable;
    }

    public TemplateDTO getTemplate() {
        return template;
    }

    public void setTemplate(TemplateDTO template) {
        this.template = template;
    }

    public SectionDTO getSection() {
        return section;
    }

    public void setSection(SectionDTO section) {
        this.section = section;
    }

    public Boolean getRepeatable() {
        return repeatable;
    }

    public void setRepeatable(Boolean repeatable) {
        this.repeatable = repeatable;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TemplateSectionDTO)) return false;
        TemplateSectionDTO that = (TemplateSectionDTO) o;
        return Objects.equals(template, that.template) &&
                Objects.equals(section, that.section);
    }

}
