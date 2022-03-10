package com.fon.bg.ac.rs.cvbuilder.service.impl;

import com.fon.bg.ac.rs.cvbuilder.dto.SectionFieldTypeDTO;
import com.fon.bg.ac.rs.cvbuilder.entity.SectionFieldType;
import com.fon.bg.ac.rs.cvbuilder.mapper.SectionFieldTypeMapper;
import com.fon.bg.ac.rs.cvbuilder.repository.SectionFieldTypeRepository;
import com.fon.bg.ac.rs.cvbuilder.service.generic.GenericCrudService;
import com.fon.bg.ac.rs.cvbuilder.util.CVBuilderException;
import com.fon.bg.ac.rs.cvbuilder.util.CVBuilderUtils;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;

@Service
@Transactional
public class SectionFieldTypeService extends GenericCrudService<SectionFieldType, SectionFieldTypeDTO, Long, SectionFieldTypeRepository, SectionFieldTypeMapper> {

    @Override
    protected void checkPreconditionsForSave(SectionFieldTypeDTO object) {
        List<String> exceptionMessages = new LinkedList<>();
        if(repository.existsById(object.getId()))
            exceptionMessages.add("Vec postoji tip polja sa unetim ID-om");
        if(repository.existsByName(object.getName()))
            exceptionMessages.add("Vec postoji tip polja sa unetim nazivom");

        CVBuilderUtils.throwExceptionIfHasMessages(exceptionMessages);

    }

    @Override
    protected void checkPreconditionsForUpdate(SectionFieldTypeDTO object) {
        List<String> exceptionMessages = new LinkedList<>();
        if(!repository.existsById(object.getId()))
            exceptionMessages.add("Ne postoji tip polja sa unetim ID-om");
        if(repository.existsByNameAndIdNot(object.getName(), object.getId()))
            exceptionMessages.add("Vec postoji tip polja sa unetim nazivom");

        CVBuilderUtils.throwExceptionIfHasMessages(exceptionMessages);
    }
}
