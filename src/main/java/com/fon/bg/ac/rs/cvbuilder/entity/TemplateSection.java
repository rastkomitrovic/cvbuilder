package com.fon.bg.ac.rs.cvbuilder.entity;

import com.fon.bg.ac.rs.cvbuilder.entity.abs.BaseEntity;
import com.fon.bg.ac.rs.cvbuilder.entity.embedded.TemplateSectionEmbeddedId;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "templatesection")
@AssociationOverrides(
        {
                @AssociationOverride(name = "templateSectionEmbeddedId.template", joinColumns = @JoinColumn(name = "template_id", nullable = false)),
                @AssociationOverride(name = "templateSectionEmbeddedId.section", joinColumns = @JoinColumn(name = "section_id", nullable = false))
        }
)
public class TemplateSection extends BaseEntity {

    @EmbeddedId
    @Fetch(value = FetchMode.JOIN)
    private TemplateSectionEmbeddedId templateSectionEmbeddedId;

    @Column(name = "order_number", nullable = false)
    private Integer orderNumber;

    @Column(name = "repeatable", nullable = false)
    private Boolean repeatable;

    public TemplateSection() {

    }

    public TemplateSection(TemplateSectionEmbeddedId templateSectionEmbeddedId, Integer orderNumber, Boolean repeatable) {
        this.templateSectionEmbeddedId = templateSectionEmbeddedId;
        this.orderNumber = orderNumber;
        this.repeatable = repeatable;
    }

    public TemplateSectionEmbeddedId getTemplateSectionEmbeddedId() {
        return templateSectionEmbeddedId;
    }

    public void setTemplateSectionEmbeddedId(TemplateSectionEmbeddedId templateSectionEmbeddedId) {
        this.templateSectionEmbeddedId = templateSectionEmbeddedId;
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
        if (!(o instanceof TemplateSection)) return false;
        TemplateSection that = (TemplateSection) o;
        return Objects.equals(templateSectionEmbeddedId, that.templateSectionEmbeddedId);
    }

}
