package com.fon.bg.ac.rs.cvbuilder.service.impl;

import com.fon.bg.ac.rs.cvbuilder.dto.SectionDTO;
import com.fon.bg.ac.rs.cvbuilder.entity.Section;
import com.fon.bg.ac.rs.cvbuilder.mapper.SectionMapper;
import com.fon.bg.ac.rs.cvbuilder.repository.SectionRepository;
import com.fon.bg.ac.rs.cvbuilder.service.generic.GenericCrudService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class SectionService extends GenericCrudService<Section, SectionDTO, Long, SectionRepository, SectionMapper> {

    @Override
    protected void checkPreconditionsForSave(SectionDTO object) {

    }

    @Override
    protected void checkPreconditionsForUpdate(SectionDTO object) {

    }
}
