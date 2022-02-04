package com.fon.bg.ac.rs.cvbuilder.entity;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "cvsection")
public class CVSection {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cv_id", nullable = false)
    private CV cv;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "section_id", nullable = false)
    private Section section;

    @OneToMany(mappedBy = "cvSectionSectionFieldEmbeddedId.cvSection", fetch = FetchType.LAZY)
    private Set<CVSectionSectionField> cvSectionSectionFields;

    public CVSection(){

    }

    public CVSection(Long id, CV cv, Section section, Set<CVSectionSectionField> cvSectionSectionFields) {
        this.id = id;
        this.cv = cv;
        this.section = section;
        this.cvSectionSectionFields = cvSectionSectionFields;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CV getCv() {
        return cv;
    }

    public void setCv(CV cv) {
        this.cv = cv;
    }

    public Section getSection() {
        return section;
    }

    public void setSection(Section section) {
        this.section = section;
    }

    public Set<CVSectionSectionField> getCvSectionSectionFields() {
        return cvSectionSectionFields;
    }

    public void setCvSectionSectionFields(Set<CVSectionSectionField> cvSectionSectionFields) {
        this.cvSectionSectionFields = cvSectionSectionFields;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CVSection)) return false;
        CVSection cvSection = (CVSection) o;
        return Objects.equals(id, cvSection.id);
    }

}
