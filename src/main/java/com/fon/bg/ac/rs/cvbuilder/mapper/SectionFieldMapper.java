package com.fon.bg.ac.rs.cvbuilder.mapper;

import com.fon.bg.ac.rs.cvbuilder.dto.SectionFieldDTO;
import com.fon.bg.ac.rs.cvbuilder.entity.SectionField;
import com.fon.bg.ac.rs.cvbuilder.util.CVBuilderUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class SectionFieldMapper extends GenericMapper<SectionField, SectionFieldDTO> {

    @Resource
    private SectionFieldTypeMapper sectionFieldTypeMapper;

    @Override
    protected SectionFieldDTO toDTOTransformation(SectionField object) {
        SectionFieldDTO sectionField = new SectionFieldDTO();
        sectionField.setId(object.getId());
        sectionField.setName(object.getName());
        sectionField.setDescription(object.getDescription());
        if (CVBuilderUtils.isLazyEntityInitialized(object.getSectionFieldType()))
            sectionField.setSectionFieldType(sectionFieldTypeMapper.toDTO(object.getSectionFieldType()));
        return sectionField;
    }

    @Override
    protected SectionField toDAOTransformation(SectionFieldDTO object) {
        SectionField sectionField = new SectionField();
        sectionField.setId(object.getId());
        sectionField.setName(object.getName());
        sectionField.setDescription(object.getDescription());
        sectionField.setSectionFieldType(sectionFieldTypeMapper.toDAO(object.getSectionFieldType()));
        return sectionField;
    }
}
