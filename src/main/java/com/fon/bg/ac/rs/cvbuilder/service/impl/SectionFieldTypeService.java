package com.fon.bg.ac.rs.cvbuilder.service.impl;

import com.fon.bg.ac.rs.cvbuilder.dto.SectionFieldTypeDTO;
import com.fon.bg.ac.rs.cvbuilder.entity.SectionFieldType;
import com.fon.bg.ac.rs.cvbuilder.mapper.SectionFieldTypeMapper;
import com.fon.bg.ac.rs.cvbuilder.repository.SectionFieldTypeRepository;
import com.fon.bg.ac.rs.cvbuilder.service.generic.GenericCrudService;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class SectionFieldTypeService extends GenericCrudService<SectionFieldType, SectionFieldTypeDTO, Long, SectionFieldTypeRepository, SectionFieldTypeMapper> {

    @Override
    protected void checkPreconditionsForSave(SectionFieldTypeDTO object) {

    }

    @Override
    protected void checkPreconditionsForUpdate(SectionFieldTypeDTO object) {

    }
}
