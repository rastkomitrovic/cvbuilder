package com.fon.bg.ac.rs.cvbuilder.entity.embedded;

import com.fon.bg.ac.rs.cvbuilder.entity.Section;
import com.fon.bg.ac.rs.cvbuilder.entity.Template;
import com.fon.bg.ac.rs.cvbuilder.entity.abs.BaseEntity;

import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class TemplateSectionEmbeddedId extends BaseEntity implements Serializable {

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "template_id", nullable = false)
    private Template template;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "section_id", nullable = false)
    private Section section;

    public TemplateSectionEmbeddedId(){

    }

    public TemplateSectionEmbeddedId(Template template, Section section) {
        this.template = template;
        this.section = section;
    }

    public Template getTemplate() {
        return template;
    }

    public void setTemplate(Template template) {
        this.template = template;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TemplateSectionEmbeddedId)) return false;
        TemplateSectionEmbeddedId that = (TemplateSectionEmbeddedId) o;
        return Objects.equals(template, that.template) &&
                Objects.equals(section, that.section);
    }

}
