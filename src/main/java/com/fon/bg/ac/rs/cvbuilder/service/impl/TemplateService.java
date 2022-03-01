package com.fon.bg.ac.rs.cvbuilder.service.impl;

import com.fon.bg.ac.rs.cvbuilder.dto.TemplateDTO;
import com.fon.bg.ac.rs.cvbuilder.entity.Template;
import com.fon.bg.ac.rs.cvbuilder.mapper.TemplateMapper;
import com.fon.bg.ac.rs.cvbuilder.repository.TemplateRepository;
import com.fon.bg.ac.rs.cvbuilder.service.generic.GenericPagingService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class TemplateService extends GenericPagingService<Template, TemplateDTO, Long, TemplateRepository, TemplateMapper> {

    @Override
    protected void checkPreconditionsForSave(TemplateDTO object) {

    }

    @Override
    protected void checkPreconditionsForUpdate(TemplateDTO object) {

    }

    @Override
    public Page<TemplateDTO> searchPage(Pageable pageable, String searchParams) {
        return null;
    }
}
