package com.fon.bg.ac.rs.cvbuilder.service.impl;

import com.fon.bg.ac.rs.cvbuilder.dto.CVDTO;
import com.fon.bg.ac.rs.cvbuilder.entity.CV;
import com.fon.bg.ac.rs.cvbuilder.mapper.CVMapper;
import com.fon.bg.ac.rs.cvbuilder.repository.CVRepository;
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
public class CVService extends GenericPagingService<CV, CVDTO, Long, CVRepository, CVMapper> {

    @Override
    public Page<CVDTO> searchPage(Pageable pageable, String searchParams) {
        return repository.searchPage(pageable, searchParams).map(it -> mapper.toDTO(it));
    }

    @Override
    protected void checkPreconditionsForSave(CVDTO object) throws CVBuilderException {
        List<String> exceptionMessages = new LinkedList<>();
        if (repository.existsById(object.getId()))
            exceptionMessages.add("Vec postoji CV sa unetim ID-om");

        CVBuilderUtils.throwExceptionIfHasMessages(exceptionMessages);
    }

    @Override
    protected void checkPreconditionsForUpdate(CVDTO object) throws CVBuilderException {
        List<String> exceptionMessages = new LinkedList<>();
        if (!repository.existsById(object.getId()))
            exceptionMessages.add("Ne postoji CV sa unetim ID-om");

        CVBuilderUtils.throwExceptionIfHasMessages(exceptionMessages);
    }

}
