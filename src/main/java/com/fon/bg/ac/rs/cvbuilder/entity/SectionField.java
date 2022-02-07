package com.fon.bg.ac.rs.cvbuilder.entity;

import com.fon.bg.ac.rs.cvbuilder.entity.abs.BaseEntity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "sectionfield")
public class SectionField extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = true)
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "section_field_type_id", nullable = false)
    private SectionFieldType sectionFieldType;

    public SectionField() {

    }

    public SectionField(Long id, String name, String description, SectionFieldType sectionFieldType) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.sectionFieldType = sectionFieldType;
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

    public SectionFieldType getSectionFieldType() {
        return sectionFieldType;
    }

    public void setSectionFieldType(SectionFieldType sectionFieldType) {
        this.sectionFieldType = sectionFieldType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SectionField)) return false;
        SectionField that = (SectionField) o;
        return Objects.equals(id, that.id);
    }

}
