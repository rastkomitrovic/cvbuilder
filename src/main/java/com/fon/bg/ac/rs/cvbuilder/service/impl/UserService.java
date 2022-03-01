package com.fon.bg.ac.rs.cvbuilder.service.impl;

import com.fon.bg.ac.rs.cvbuilder.dto.UserDTO;
import com.fon.bg.ac.rs.cvbuilder.entity.User;
import com.fon.bg.ac.rs.cvbuilder.mapper.RoleMapper;
import com.fon.bg.ac.rs.cvbuilder.mapper.UserMapper;
import com.fon.bg.ac.rs.cvbuilder.repository.UserRepository;
import com.fon.bg.ac.rs.cvbuilder.service.generic.GenericPagingService;
import com.fon.bg.ac.rs.cvbuilder.util.CVBuilderException;
import com.fon.bg.ac.rs.cvbuilder.util.CVBuilderUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@Service
@Transactional
public class UserService extends GenericPagingService<User, UserDTO, Long, UserRepository, UserMapper> {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public Page<UserDTO> searchPage(Pageable pageable, String searchParams) {
        return null;
    }

    @Override
    protected void checkPreconditionsForSave(UserDTO object) throws CVBuilderException {
        List<String> exceptionMessages = new LinkedList<>();
        if (repository.existsById(object.getId()))
            exceptionMessages.add("Vec postoji korisnik sa unetim ID-om: " + object.getId());
        if (repository.existsByUsername(object.getUsername()))
            exceptionMessages.add("Vec postoji korisnik sa unetim korisnickim imenom: " + object.getUsername());
        if (repository.existsByEmail(object.getEmail()))
            exceptionMessages.add("Vec postoji korisnik sa unetim email-om: " + object.getEmail());
        if (repository.existsByIndexNumber(object.getIndexNumber()))
            exceptionMessages.add("Vec postoji korisnik sa unetim brojem indeksa: " + object.getIndexNumber());
        if (object.getRole() == null)
            exceptionMessages.add("Korisnik nema podesenu rolu");
        CVBuilderUtils.throwExceptionIfHasMessages(exceptionMessages);
    }

    @Override
    protected void checkPreconditionsForUpdate(UserDTO object) throws CVBuilderException {
        List<String> exceptionMessages = new LinkedList<>();
        if (!repository.existsById(object.getId()))
            exceptionMessages.add("Ne postoji korsinik sa unetim ID-om: " + object.getId());
        if (object.getUsername() != null && repository.existsByUsernameAndIdNot(object.getUsername(), object.getId()))
            exceptionMessages.add("Vec postoji korisnik sa unetim korisnickim imenom: " + object.getUsername());
        if (object.getEmail() != null && repository.existsByEmailAndIdNot(object.getEmail(), object.getId()))
            exceptionMessages.add("Vec postoji korisnik sa unetim email-om: " + object.getEmail());
        if (object.getIndexNumber() != null && repository.existsByIndexNumberAndIdNot(object.getIndexNumber(), object.getId()))
            exceptionMessages.add("Vec postoji korisnik sa unetim brojem indeksa: " + object.getIndexNumber());
        Optional<User> userOptional = repository.findById(object.getId());
        if (!userOptional.isPresent())
            exceptionMessages.add("Greska u pronalazenju korisnika sa unetim ID-om: " + object.getId());

        User user = userOptional.get();


        CVBuilderUtils.throwExceptionIfHasMessages(exceptionMessages);
    }
}
