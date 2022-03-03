package com.fon.bg.ac.rs.cvbuilder.service.impl;

import com.fon.bg.ac.rs.cvbuilder.dto.SectionDTO;
import com.fon.bg.ac.rs.cvbuilder.entity.Section;
import com.fon.bg.ac.rs.cvbuilder.mapper.SectionMapper;
import com.fon.bg.ac.rs.cvbuilder.repository.SectionRepository;
import com.fon.bg.ac.rs.cvbuilder.service.generic.GenericCrudService;
import com.fon.bg.ac.rs.cvbuilder.util.CVBuilderException;
import com.fon.bg.ac.rs.cvbuilder.util.CVBuilderUtils;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;

@Service
@Transactional
public class SectionService extends GenericCrudService<Section, SectionDTO, Long, SectionRepository, SectionMapper> {

    @Override
    protected void checkPreconditionsForSave(SectionDTO object) throws CVBuilderException {
        List<String> exceptionMessages = new LinkedList<>();
        if(repository.existsById(object.getId()))
            exceptionMessages.add("Vec postoji sekcija sa unetim ID-om");
        if(repository.existsByName(object.getName()))
            exceptionMessages.add("Vec postoji sekcija sa unetim nazivom");

        CVBuilderUtils.throwExceptionIfHasMessages(exceptionMessages);
    }

    @Override
    protected void checkPreconditionsForUpdate(SectionDTO object) throws CVBuilderException {
        List<String> exceptionMessages = new LinkedList<>();
        if(!repository.existsById(object.getId()))
            exceptionMessages.add("Ne postoji sekcija sa unetim ID-om");
        if(repository.existsByNameAndIdNot(object.getName(),object.getId()))
            exceptionMessages.add("Vec postoji sekcija sa unetim nazivom");

        CVBuilderUtils.throwExceptionIfHasMessages(exceptionMessages);
    }
}
