package com.fon.bg.ac.rs.cvbuilder.service.impl;

import com.fon.bg.ac.rs.cvbuilder.dto.RoleDTO;
import com.fon.bg.ac.rs.cvbuilder.entity.Role;
import com.fon.bg.ac.rs.cvbuilder.mapper.RoleMapper;
import com.fon.bg.ac.rs.cvbuilder.repository.RoleRepository;
import com.fon.bg.ac.rs.cvbuilder.service.generic.GenericCrudService;
import com.fon.bg.ac.rs.cvbuilder.util.CVBuilderException;
import com.fon.bg.ac.rs.cvbuilder.util.CVBuilderUtils;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;

@Service
@Transactional
public class RoleService extends GenericCrudService<Role, RoleDTO, Long, RoleRepository, RoleMapper> {

    @Override
    protected void checkPreconditionsForSave(RoleDTO object) throws CVBuilderException {
        List<String> exceptionMessages = new LinkedList<>();
        if (repository.existsById(object.getId()))
            exceptionMessages.add("Vec postoji rola sa unetim ID-om");
        if (repository.existsByName(object.getName()))
            exceptionMessages.add("Vec postoji rola sa unetim nazivoms");

        CVBuilderUtils.throwExceptionIfHasMessages(exceptionMessages);
    }

    @Override
    protected void checkPreconditionsForUpdate(RoleDTO object) throws CVBuilderException {
        List<String> exceptionMessages = new LinkedList<>();
        if (!repository.existsById(object.getId()))
            exceptionMessages.add("Ne postoji rola sa unetim ID-om");
        if(repository.existsByNameAndIdNot(object.getName(),object.getId()))
            exceptionMessages.add("Vec postoji rola sa unetim nazivom");

        CVBuilderUtils.throwExceptionIfHasMessages(exceptionMessages);
    }
}
