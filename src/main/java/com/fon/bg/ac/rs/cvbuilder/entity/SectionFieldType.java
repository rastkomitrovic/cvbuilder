package com.fon.bg.ac.rs.cvbuilder.entity;

import com.fon.bg.ac.rs.cvbuilder.entity.abs.BaseEntity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "sectionfieldtype")
public class SectionFieldType extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "key_value", nullable = false, unique = true)
    private String keyValue;

    @Column(name = "description", nullable = true)
    private String description;

    public SectionFieldType() {

    }

    public SectionFieldType(Long id, String name, String keyValue, String description) {
        this.id = id;
        this.name = name;
        this.keyValue = keyValue;
        this.description = description;
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

    public String getKeyValue() {
        return keyValue;
    }

    public void setKeyValue(String keyValue) {
        this.keyValue = keyValue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SectionFieldType)) return false;
        SectionFieldType that = (SectionFieldType) o;
        return Objects.equals(id, that.id);
    }

}
