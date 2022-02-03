package com.fon.bg.ac.rs.cvbuilder.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "sectionfield")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class SectionField {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id",nullable = false,unique = true)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = true)
    @ToString.Exclude
    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "section_field_type_id", nullable = false)
    @ToString.Exclude
    private SectionFieldType sectionFieldType;
}
