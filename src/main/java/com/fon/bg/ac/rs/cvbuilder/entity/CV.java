package com.fon.bg.ac.rs.cvbuilder.entity;

import com.fon.bg.ac.rs.cvbuilder.entity.abs.BaseEntity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "cv")
public class CV extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    @Column(name = "name", nullable = false, unique = false)
    private String name;

    @Column(name = "description", nullable = true)
    private String description;

    @Basic
    @Column(name = "date_created", nullable = false)
    private LocalDateTime dateCreated;

    @Basic
    @Column(name = "date_edited", nullable = true)
    private LocalDateTime dateEdited;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "template_id", nullable = true)
    private Template template;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToMany(mappedBy = "cv", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<CVSection> cvSections;

    public CV() {

    }

    public CV(Long id, String name, String description, LocalDateTime dateCreated, LocalDateTime dateEdited, Template template, User user, Set<CVSection> cvSections) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.dateCreated = dateCreated;
        this.dateEdited = dateEdited;
        this.template = template;
        this.user = user;
        this.cvSections = cvSections;
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

    public LocalDateTime getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(LocalDateTime dateCreated) {
        this.dateCreated = dateCreated;
    }

    public LocalDateTime getDateEdited() {
        return dateEdited;
    }

    public void setDateEdited(LocalDateTime dateEdited) {
        this.dateEdited = dateEdited;
    }

    public Template getTemplate() {
        return template;
    }

    public void setTemplate(Template template) {
        this.template = template;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Set<CVSection> getCvSections() {
        return cvSections;
    }

    public void setCvSections(Set<CVSection> cvSections) {
        this.cvSections = cvSections;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CV)) return false;
        CV cv = (CV) o;
        return Objects.equals(id, cv.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
