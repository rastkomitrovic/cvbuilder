package com.fon.bg.ac.rs.cvbuilder.mapper;

import com.fon.bg.ac.rs.cvbuilder.dto.SectionFieldTypeDTO;
import com.fon.bg.ac.rs.cvbuilder.entity.SectionFieldType;
import com.fon.bg.ac.rs.cvbuilder.mapper.generic.GenericMapper;
import org.springframework.stereotype.Service;

@Service
public class SectionFieldTypeMapper extends GenericMapper<SectionFieldType, SectionFieldTypeDTO> {

    @Override
    protected SectionFieldTypeDTO toDTOTransformation(SectionFieldType object) {
        SectionFieldTypeDTO sectionField = new SectionFieldTypeDTO();
        sectionField.setId(object.getId());
        sectionField.setName(object.getName());
        sectionField.setDescription(object.getDescription());
        return sectionField;
    }

    @Override
    protected SectionFieldType toDAOTransformation(SectionFieldTypeDTO object) {
        SectionFieldType sectionField = new SectionFieldType();
        sectionField.setId(object.getId());
        sectionField.setName(object.getName());
        sectionField.setDescription(object.getDescription());
        return sectionField;
    }
}
