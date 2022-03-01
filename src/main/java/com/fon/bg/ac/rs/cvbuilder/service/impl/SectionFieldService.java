package com.fon.bg.ac.rs.cvbuilder.service.impl;

import com.fon.bg.ac.rs.cvbuilder.dto.SectionFieldDTO;
import com.fon.bg.ac.rs.cvbuilder.entity.SectionField;
import com.fon.bg.ac.rs.cvbuilder.mapper.SectionFieldMapper;
import com.fon.bg.ac.rs.cvbuilder.repository.SectionFieldRepository;
import com.fon.bg.ac.rs.cvbuilder.service.generic.GenericCrudService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class SectionFieldService extends GenericCrudService<SectionField, SectionFieldDTO, Long, SectionFieldRepository, SectionFieldMapper> {

    @Override
    protected void checkPreconditionsForSave(SectionFieldDTO object) {

    }

    @Override
    protected void checkPreconditionsForUpdate(SectionFieldDTO object) {

    }
}
