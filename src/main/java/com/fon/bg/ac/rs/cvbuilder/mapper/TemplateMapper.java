package com.fon.bg.ac.rs.cvbuilder.mapper;

import com.fon.bg.ac.rs.cvbuilder.dto.TemplateDTO;
import com.fon.bg.ac.rs.cvbuilder.dto.TemplateSectionDTO;
import com.fon.bg.ac.rs.cvbuilder.entity.Template;
import com.fon.bg.ac.rs.cvbuilder.entity.TemplateSection;
import com.fon.bg.ac.rs.cvbuilder.entity.embedded.TemplateSectionEmbeddedId;
import com.fon.bg.ac.rs.cvbuilder.mapper.generic.GenericMapper;
import com.fon.bg.ac.rs.cvbuilder.util.CVBuilderUtils;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class TemplateMapper extends GenericMapper<Template, TemplateDTO> {

    @Resource
    private SectionMapper sectionMapper;

    @Resource
    private UserMapper userMapper;

    @Override
    protected TemplateDTO toDTOTransformation(Template object) {
        TemplateDTO template = new TemplateDTO();
        template.setId(object.getId());
        template.setName(object.getName());
        template.setDescription(object.getDescription());
        template.setPrivateTemplate(object.isPrivateTemplate());
        if(CVBuilderUtils.isLazyEntityInitialized(object.getUser()))
            template.setUser(userMapper.toDTO(object.getUser()));
        if(CVBuilderUtils.isLazyInitializedCollection(object.getTemplateSections()))
            template.setTemplateSections(mapTemplateSectionsToDTO(object.getTemplateSections(),template));
        return template;
    }

    private List<TemplateSectionDTO> mapTemplateSectionsToDTO(Set<TemplateSection> templateSections, TemplateDTO template) {
        List<TemplateSectionDTO> list = new LinkedList<>();
        if(templateSections == null)
            return list;
        templateSections.forEach(value -> {
            TemplateSectionDTO templateSection = new TemplateSectionDTO();
            templateSection.setTemplate(template);
            templateSection.setSection(sectionMapper.toDTO(value.getTemplateSectionEmbeddedId().getSection()));
            templateSection.setRepeatable(value.isRepeatable());
            list.add(templateSection);
        });
        return list;
    }

    @Override
    protected Template toDAOTransformation(TemplateDTO object) {
        Template template = new Template();
        template.setId(object.getId());
        template.setName(object.getName());
        template.setDescription(object.getDescription());
        template.setPrivateTemplate(object.isPrivateTemplate());
        template.setUser(userMapper.toDAO(object.getUser()));
        template.setTemplateSections(mapTemplateSectionsToDAO(object.getTemplateSections(),template));
        return template;
    }

    private Set<TemplateSection> mapTemplateSectionsToDAO(List<TemplateSectionDTO> templateSections, Template template) {
        Set<TemplateSection> set = new HashSet<>();
        if(templateSections == null)
            return set;
        templateSections.forEach(value -> {
            TemplateSection templateSection = new TemplateSection();
            TemplateSectionEmbeddedId templateSectionEmbeddedId = new TemplateSectionEmbeddedId();
            templateSectionEmbeddedId.setTemplate(template);
            templateSectionEmbeddedId.setSection(sectionMapper.toDAO(value.getSection()));
            templateSection.setTemplateSectionEmbeddedId(templateSectionEmbeddedId);
            templateSection.setRepeatable(value.isRepeatable());
            set.add(templateSection);
        });
        return set;
    }
}
