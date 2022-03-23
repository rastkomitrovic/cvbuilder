package com.fon.bg.ac.rs.cvbuilder.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class TemplateSectionDTO {

    @JsonBackReference
    private TemplateDTO template;

    @NotNull(message = "Sekcija u sekciji sablona ne sme biti prazna")
    private SectionDTO section;

    @NotNull(message = "Redni broj sekcije u sablonu ne sme biti prazan")
    @Min(value = 1, message = "Redni broj sekcije u sablonu mora biti 1 ili vece")
    private Integer orderNumber;

    @NotNull(message = "Naznaka da li sekcija moze da se ponavlja u sablonu ne sme biti prazna")
    private Boolean repeatable;

    public TemplateSectionDTO(){

    }

    public TemplateSectionDTO(TemplateDTO template, SectionDTO section, Integer orderNumber, Boolean repeatable) {
        this.template = template;
        this.section = section;
        this.orderNumber = orderNumber;
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

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Boolean isRepeatable() {
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
