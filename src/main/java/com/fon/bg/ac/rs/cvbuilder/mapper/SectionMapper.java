package com.fon.bg.ac.rs.cvbuilder.mapper;

import com.fon.bg.ac.rs.cvbuilder.dto.SectionDTO;
import com.fon.bg.ac.rs.cvbuilder.dto.SectionSectionFieldDTO;
import com.fon.bg.ac.rs.cvbuilder.entity.Section;
import com.fon.bg.ac.rs.cvbuilder.entity.SectionSectionField;
import com.fon.bg.ac.rs.cvbuilder.entity.embedded.SectionSectionFieldEmbeddedId;
import com.fon.bg.ac.rs.cvbuilder.mapper.generic.GenericMapper;
import com.fon.bg.ac.rs.cvbuilder.util.CVBuilderUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Service
public class SectionMapper extends GenericMapper<Section, SectionDTO> {

    @Resource
    private SectionFieldMapper sectionFieldMapper;

    @Override
    protected SectionDTO toDTOTransformation(Section object) {
        SectionDTO section = new SectionDTO();
        section.setId(object.getId());
        section.setName(object.getName());
        section.setDescription(object.getDescription());
        if (CVBuilderUtils.isLazyInitializedCollection(object.getSectionSectionFields()))
            section.setSectionSectionFields(mapSectionSectionFieldsToDTO(object.getSectionSectionFields(), section));
        return section;
    }

    private List<SectionSectionFieldDTO> mapSectionSectionFieldsToDTO(Set<SectionSectionField> set, SectionDTO section) {
        List<SectionSectionFieldDTO> list = new LinkedList<>();
        if (set == null)
            return list;
        set.forEach(value -> {
            SectionSectionFieldDTO sectionSectionField = new SectionSectionFieldDTO();
            sectionSectionField.setSection(section);
            sectionSectionField.setSectionField(sectionFieldMapper.toDTO(value.getSectionSectionFieldEmbeddedId().getSectionField()));
            sectionSectionField.setOrderNumber(value.getOrderNumber());
            list.add(sectionSectionField);
        });
        return list;
    }

    @Override
    protected Section toDAOTransformation(SectionDTO object) {
        Section section = new Section();
        section.setId(object.getId());
        section.setName(object.getName());
        section.setDescription(object.getDescription());
        section.setSectionSectionFields(mapSectionSectionFieldsToDAO(object.getSectionSectionFields(), section));
        return section;
    }

    private Set<SectionSectionField> mapSectionSectionFieldsToDAO(List<SectionSectionFieldDTO> list, Section section) {
        Set<SectionSectionField> set = new HashSet<>();
        if (list == null)
            return set;
        list.forEach(value -> {
            SectionSectionField sectionSectionField = new SectionSectionField();
            SectionSectionFieldEmbeddedId id = new SectionSectionFieldEmbeddedId();
            id.setSection(section);
            id.setSectionField(sectionFieldMapper.toDAO(value.getSectionField()));
            sectionSectionField.setSectionSectionFieldEmbeddedId(id);
            sectionSectionField.setOrderNumber(value.getOrderNumber());
            set.add(sectionSectionField);
        });
        return set;
    }
}
