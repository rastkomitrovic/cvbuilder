package com.fon.bg.ac.rs.cvbuilder.service.impl;

import com.fon.bg.ac.rs.cvbuilder.dto.TemplateDTO;
import com.fon.bg.ac.rs.cvbuilder.entity.Template;
import com.fon.bg.ac.rs.cvbuilder.mapper.TemplateMapper;
import com.fon.bg.ac.rs.cvbuilder.repository.TemplateRepository;
import com.fon.bg.ac.rs.cvbuilder.service.generic.GenericPagingService;
import com.fon.bg.ac.rs.cvbuilder.util.CVBuilderException;
import com.fon.bg.ac.rs.cvbuilder.util.CVBuilderUtils;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;

@Service
@Transactional
public class TemplateService extends GenericPagingService<Template, TemplateDTO, Long, TemplateRepository, TemplateMapper> {

    @Override
    protected void checkPreconditionsForSave(TemplateDTO object) throws CVBuilderException {
        List<String> exceptionMessages = new LinkedList<>();
        if(repository.existsById(object.getId()))
            exceptionMessages.add("Vec postoji sablon sa unetim ID-om");

        CVBuilderUtils.throwExceptionIfHasMessages(exceptionMessages);
    }

    @Override
    protected void checkPreconditionsForUpdate(TemplateDTO object) throws CVBuilderException {
        List<String> exceptionMessages = new LinkedList<>();
        if(!repository.existsById(object.getId()))
            exceptionMessages.add("Ne postoji sablon sa unetim ID-om");

        CVBuilderUtils.throwExceptionIfHasMessages(exceptionMessages);
    }

    @Override
    public Page<TemplateDTO> searchPage(Pageable pageable, String searchParams) {
        return repository.searchPage(pageable,searchParams).map(it -> mapper.toDTO(it));
    }
}
