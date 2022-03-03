package com.fon.bg.ac.rs.cvbuilder.service.impl;

import com.fon.bg.ac.rs.cvbuilder.dto.SectionFieldDTO;
import com.fon.bg.ac.rs.cvbuilder.entity.SectionField;
import com.fon.bg.ac.rs.cvbuilder.mapper.SectionFieldMapper;
import com.fon.bg.ac.rs.cvbuilder.repository.SectionFieldRepository;
import com.fon.bg.ac.rs.cvbuilder.service.generic.GenericCrudService;
import com.fon.bg.ac.rs.cvbuilder.util.CVBuilderException;
import com.fon.bg.ac.rs.cvbuilder.util.CVBuilderUtils;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;

@Service
@Transactional
public class SectionFieldService extends GenericCrudService<SectionField, SectionFieldDTO, Long, SectionFieldRepository, SectionFieldMapper> {

    @Override
    protected void checkPreconditionsForSave(SectionFieldDTO object) throws CVBuilderException {
        List<String> exceptionMessages = new LinkedList<>();
        if(repository.existsById(object.getId()))
            exceptionMessages.add("Vec postoji polje sekcije sa unetim ID-om");

        CVBuilderUtils.throwExceptionIfHasMessages(exceptionMessages);
    }

    @Override
    protected void checkPreconditionsForUpdate(SectionFieldDTO object) throws CVBuilderException {
        List<String> exceptionMessages = new LinkedList<>();
        if(!repository.existsById(object.getId()))
            exceptionMessages.add("Ne postoji polje sekcije sa unetim ID-om");

        CVBuilderUtils.throwExceptionIfHasMessages(exceptionMessages);
    }
}
