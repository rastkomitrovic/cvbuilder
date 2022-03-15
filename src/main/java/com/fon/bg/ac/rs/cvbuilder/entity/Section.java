package com.fon.bg.ac.rs.cvbuilder.entity;

import com.fon.bg.ac.rs.cvbuilder.entity.abs.BaseEntity;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "section")
public class Section extends BaseEntity {

    @Column(name = "id", nullable = false, unique = true)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "description", nullable = true)
    private String description;

    @OneToMany(mappedBy = "sectionSectionFieldEmbeddedId.section", fetch = FetchType.LAZY)
    @OrderBy("orderNumber")
    private Set<SectionSectionField> sectionSectionFields;

    public Section() {

    }

    public Section(Long id, String name, String description, Set<SectionSectionField> sectionSectionFields) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.sectionSectionFields = sectionSectionFields;
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

    public Set<SectionSectionField> getSectionSectionFields() {
        return sectionSectionFields;
    }

    public void setSectionSectionFields(Set<SectionSectionField> sectionSectionFields) {
        this.sectionSectionFields = sectionSectionFields;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Section section = (Section) o;
        return Objects.equals(id, section.id);
    }

}
