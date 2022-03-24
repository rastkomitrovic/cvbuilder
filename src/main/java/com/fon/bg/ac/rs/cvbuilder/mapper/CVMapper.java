package com.fon.bg.ac.rs.cvbuilder.mapper;

import com.fon.bg.ac.rs.cvbuilder.dto.CVDTO;
import com.fon.bg.ac.rs.cvbuilder.dto.CVSectionDTO;
import com.fon.bg.ac.rs.cvbuilder.dto.CVSectionSectionFieldDTO;
import com.fon.bg.ac.rs.cvbuilder.entity.CV;
import com.fon.bg.ac.rs.cvbuilder.entity.CVSection;
import com.fon.bg.ac.rs.cvbuilder.entity.CVSectionSectionField;
import com.fon.bg.ac.rs.cvbuilder.entity.embedded.CVSectionSectionFieldEmbeddedId;
import com.fon.bg.ac.rs.cvbuilder.mapper.generic.GenericMapper;
import com.fon.bg.ac.rs.cvbuilder.util.CVBuilderUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.ZoneId;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

@Service
public class CVMapper extends GenericMapper<CV, CVDTO> {

    @Resource
    private UserMapper userMapper;

    @Resource
    private TemplateMapper templateMapper;

    @Resource
    private SectionMapper sectionMapper;

    @Resource
    private SectionFieldMapper sectionFieldMapper;

    @Override
    protected CVDTO toDTOTransformation(CV object) {
        CVDTO cv = new CVDTO();
        cv.setId(object.getId());
        cv.setName(object.getName());
        cv.setDescription(object.getDescription());
        cv.setDateCreated(object.getDateCreated().atZone(ZoneId.systemDefault()).toInstant());
        if(cv.getDateEdited()!=null)
            cv.setDateEdited(object.getDateEdited().atZone(ZoneId.systemDefault()).toInstant());
        if (CVBuilderUtils.isLazyEntityInitialized(object.getTemplate()))
            cv.setTemplate(templateMapper.toDTO(object.getTemplate()));
        if (CVBuilderUtils.isLazyEntityInitialized(object.getUser()))
            cv.setUser(userMapper.toDTO(object.getUser()));
        if (CVBuilderUtils.isLazyInitializedCollection(object.getCvSections()))
            cv.setCvSections(mapCvSectionsToDTO(object.getCvSections(), cv));
        return cv;
    }

    private List<CVSectionDTO> mapCvSectionsToDTO(Set<CVSection> cvSections, CVDTO cv) {
        List<CVSectionDTO> list = new LinkedList<>();
        if (cvSections == null)
            return list;
        cvSections.forEach(value -> {
            CVSectionDTO cvSection = new CVSectionDTO();
            cvSection.setId(value.getId());
            cvSection.setCv(cv);
            if(CVBuilderUtils.isLazyEntityInitialized(value.getSection()))
                cvSection.setSection(sectionMapper.toDTO(value.getSection()));
            cvSection.setOrderNumber(value.getOrderNumber());
            cvSection.setCvSectionSectionFields(mapCvSectionSectionFieldsToDTO(value.getCvSectionSectionFields(), cvSection));
            list.add(cvSection);
        });
        return list;
    }

    private List<CVSectionSectionFieldDTO> mapCvSectionSectionFieldsToDTO(Set<CVSectionSectionField> cvSectionSectionFields, CVSectionDTO cvSection) {
        List<CVSectionSectionFieldDTO> list = new LinkedList<>();
        if (cvSectionSectionFields == null)
            return list;
        cvSectionSectionFields.forEach(value -> {
            CVSectionSectionFieldDTO cvSectionSectionField = new CVSectionSectionFieldDTO();
            cvSectionSectionField.setCvSection(cvSection);
            if(CVBuilderUtils.isLazyEntityInitialized(value.getSectionField()))
                cvSectionSectionField.setSectionField(sectionFieldMapper.toDTO(value.getSectionField()));
            cvSectionSectionField.setOrderNumber(value.getOrderNumber());
            cvSectionSectionField.setStringValue(value.getStringValue());
            cvSectionSectionField.setNumberValue(value.getNumberValue());
            cvSectionSectionField.setDoubleValue(value.getDoubleValue());
            cvSectionSectionField.setDateValue(value.getDateValue());
            cvSectionSectionField.setDateTimeValue(value.getDateTimeValue());
            cvSectionSectionField.setBlobValue(value.getBlobValue());
            list.add(cvSectionSectionField);
        });
        return list;
    }

    @Override
    protected CV toDAOTransformation(CVDTO object) {
        CV cv = new CV();
        cv.setId(object.getId());
        cv.setName(object.getName());
        cv.setDescription(object.getDescription());
        if (object.getDateCreated() != null)
            cv.setDateCreated(object.getDateCreated().atZone(ZoneId.systemDefault()).toLocalDateTime());
        if (object.getDateEdited() != null)
            cv.setDateEdited(object.getDateEdited().atZone(ZoneId.systemDefault()).toLocalDateTime());
        cv.setTemplate(templateMapper.toDAO(object.getTemplate()));
        cv.setUser(userMapper.toDAO(object.getUser()));
        cv.setCvSections(mapCvSectionsToDAO(object.getCvSections(), cv));
        return cv;
    }

    private Set<CVSection> mapCvSectionsToDAO(List<CVSectionDTO> cvSections, CV cv) {
        Set<CVSection> set = new HashSet<>();
        if (cvSections == null)
            return set;
        cvSections.forEach(value -> {
            CVSection cvSection = new CVSection();
            cvSection.setId(value.getId());
            cvSection.setCv(cv);
            cvSection.setSection(sectionMapper.toDAO(value.getSection()));
            cvSection.setOrderNumber(value.getOrderNumber());
            cvSection.setCvSectionSectionFields(mapCvSectionSectionFieldsToDAO(value.getCvSectionSectionFields(), cvSection));
            set.add(cvSection);
        });
        return set;
    }

    private Set<CVSectionSectionField> mapCvSectionSectionFieldsToDAO(List<CVSectionSectionFieldDTO> cvSectionSectionFields, CVSection cvSection) {
        Set<CVSectionSectionField> set = new HashSet<>();
        if (cvSectionSectionFields == null)
            return set;
        cvSectionSectionFields.forEach(value -> {
            CVSectionSectionField sectionSectionField = new CVSectionSectionField();
            CVSectionSectionFieldEmbeddedId id = new CVSectionSectionFieldEmbeddedId();
            id.setCvSectionId(cvSection.getId());
            id.setSectionFieldId(value.getSectionField().getId());
            sectionSectionField.setCvSection(cvSection);
            sectionSectionField.setSectionField(sectionFieldMapper.toDAO(value.getSectionField()));
            sectionSectionField.setCvSectionSectionFieldEmbeddedId(id);
            sectionSectionField.setOrderNumber(value.getOrderNumber());
            sectionSectionField.setStringValue(value.getStringValue());
            sectionSectionField.setNumberValue(value.getNumberValue());
            sectionSectionField.setDoubleValue(value.getDoubleValue());
            sectionSectionField.setDateValue(value.getDateValue());
            sectionSectionField.setDateTimeValue(value.getDateTimeValue());
            sectionSectionField.setBlobValue(value.getBlobValue());
            set.add(sectionSectionField);
        });
        return set;
    }
}
