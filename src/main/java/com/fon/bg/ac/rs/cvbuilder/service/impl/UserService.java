package com.fon.bg.ac.rs.cvbuilder.service.impl;

import com.fon.bg.ac.rs.cvbuilder.dto.UserDTO;
import com.fon.bg.ac.rs.cvbuilder.entity.User;
import com.fon.bg.ac.rs.cvbuilder.mapper.RoleMapper;
import com.fon.bg.ac.rs.cvbuilder.mapper.UserMapper;
import com.fon.bg.ac.rs.cvbuilder.repository.UserRepository;
import com.fon.bg.ac.rs.cvbuilder.service.generic.GenericPagingService;
import com.fon.bg.ac.rs.cvbuilder.util.CVBuilderUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService extends GenericPagingService<User, UserDTO, Long, UserRepository, UserMapper> {

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public Page<UserDTO> searchPage(Pageable pageable, String searchParam) {
        return repository.searchPage(pageable,searchParam).map(it -> mapper.toDTO(it));
    }

    @Override
    protected void checkPreconditionsForSave(UserDTO object) {
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
    protected void checkPreconditionsForUpdate(UserDTO object) {
        List<String> exceptionMessages = new LinkedList<>();
        Optional<User> user = repository.findById(object.getId());
        if (!user.isPresent())
            exceptionMessages.add("Ne postoji korsinik sa unetim ID-om: " + object.getId());
        else if (!passwordEncoder.matches(object.getOldPassword(),user.get().getPassword()))
            exceptionMessages.add("Sifra korisnika se ne podudara");
        if (repository.existsByUsernameAndIdNot(object.getUsername(), object.getId()))
            exceptionMessages.add("Vec postoji korisnik sa unetim korisnickim imenom: " + object.getUsername());
        if (repository.existsByEmailAndIdNot(object.getEmail(), object.getId()))
            exceptionMessages.add("Vec postoji korisnik sa unetim email-om: " + object.getEmail());
        if (repository.existsByIndexNumberAndIdNot(object.getIndexNumber(), object.getId()))
            exceptionMessages.add("Vec postoji korisnik sa unetim brojem indeksa: " + object.getIndexNumber());

        CVBuilderUtils.throwExceptionIfHasMessages(exceptionMessages);
    }
}
