package com.fon.bg.ac.rs.cvbuilder.service.impl;

import com.fon.bg.ac.rs.cvbuilder.dto.CVDTO;
import com.fon.bg.ac.rs.cvbuilder.entity.CV;
import com.fon.bg.ac.rs.cvbuilder.mapper.CVMapper;
import com.fon.bg.ac.rs.cvbuilder.repository.CVRepository;
import com.fon.bg.ac.rs.cvbuilder.service.generic.GenericPagingService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class CVService extends GenericPagingService<CV, CVDTO, Long, CVRepository, CVMapper> {

    @Override
    public Page<CVDTO> searchPage(Pageable pageable, String searchParams) {
        return repository.searchPage(pageable,searchParams).map(it -> mapper.toDTO(it));
    }

    @Override
    protected void checkPreconditionsForSave(CVDTO object) {

    }

    @Override
    protected void checkPreconditionsForUpdate(CVDTO object) {

    }

}
