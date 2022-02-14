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

    @Column(name = "repeatable", nullable = false)
    private Boolean repeatable;

    public TemplateSection() {

    }

    public TemplateSection(TemplateSectionEmbeddedId templateSectionEmbeddedId, Boolean repeatable) {
        this.templateSectionEmbeddedId = templateSectionEmbeddedId;
        this.repeatable = repeatable;
    }

    public TemplateSectionEmbeddedId getTemplateSectionEmbeddedId() {
        return templateSectionEmbeddedId;
    }

    public void setTemplateSectionEmbeddedId(TemplateSectionEmbeddedId templateSectionEmbeddedId) {
        this.templateSectionEmbeddedId = templateSectionEmbeddedId;
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
