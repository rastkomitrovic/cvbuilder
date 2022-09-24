package com.fon.bg.ac.rs.cvbuilder.service.impl;

import com.fon.bg.ac.rs.cvbuilder.dto.user.*;
import com.fon.bg.ac.rs.cvbuilder.entity.Role;
import com.fon.bg.ac.rs.cvbuilder.entity.User;
import com.fon.bg.ac.rs.cvbuilder.mapper.UserMapper;
import com.fon.bg.ac.rs.cvbuilder.repository.RoleRepository;
import com.fon.bg.ac.rs.cvbuilder.repository.UserRepository;
import com.fon.bg.ac.rs.cvbuilder.util.CVBuilderException;
import com.fon.bg.ac.rs.cvbuilder.util.CVBuilderUtils;
import org.apache.commons.validator.routines.EmailValidator;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class UserService {

    @Resource
    private UserRepository userRepository;

    @Resource
    private RoleRepository roleRepository;
    @Resource
    private UserMapper userMapper;

    @Resource
    private BCryptPasswordEncoder passwordEncoder;

    private static String USER_ROLE_NAME = "USER";


    public Optional<FindUserDTO> findUserById(Long id) {
        return userRepository.findById(id).map(userMapper::toFindUserDTO);
    }

    public void registerUser(@Valid RegisterUserDTO registerUserDTO) {
        checkPreconditionsForRegisterUser(registerUserDTO);

        Optional<Role> role = roleRepository.findByName(USER_ROLE_NAME);
        if (!role.isPresent())
            throw new CVBuilderException(Collections.singletonList("Basic User role not found!"));

        userRepository.save(userMapper.toDAORegisterUser(registerUserDTO, role.get()));
    }

    public void adminUserRegister(@Valid AdminUserRegisterDTO adminUserRegisterDTO) {
        checkPreconditionsForAdminRegisterUser(adminUserRegisterDTO);

        userRepository.save(userMapper.toDAO(adminUserRegisterDTO));
    }

    public void updateUser(@Valid UpdateUserDTO updateUserDTO) {
        checkPreconditionsForUpdate(updateUserDTO);

        User user = userRepository.findById(updateUserDTO.getId()).get();

        userMapper.mapToDAOForUserUpdate(user, updateUserDTO);

        userRepository.save(user);
    }

    public void adminUserUpdate(@Valid AdminUserUpdateDTO adminUserUpdateDTO) {
        checkPreconditionsForAdminUpdate(adminUserUpdateDTO);

        User user = userRepository.findById(adminUserUpdateDTO.getId()).get();

        userMapper.mapToDAOForAdminUserUpdate(user, adminUserUpdateDTO);

        userRepository.save(user);
    }

    public void deactivateUser(Long id) {
        checkPreconditionsForDeactivate(id);

        userRepository.deactivateUser(id);
    }

    public Page<FindUserDTO> findPage(Pageable pageable) {
        return userRepository.findAll(pageable).map(userMapper::toFindUserDTO);
    }

    public Page<FindUserDTO> searchPage(Pageable pageable, String searchParam) {
        return userRepository.searchPage(pageable, searchParam).map(userMapper::toFindUserDTO);
    }


    private void checkPreconditionsForRegisterUser(RegisterUserDTO registerUserDTO) {
        List<String> exceptionMessages = new LinkedList<>();
        if (userRepository.existsByUsername(registerUserDTO.getUsername()))
            exceptionMessages.add("Vec postoji korisnik sa unetim korisnickim imenom: " + registerUserDTO.getUsername());
        if (userRepository.existsByEmail(registerUserDTO.getEmail()))
            exceptionMessages.add("Vec postoji korisnik sa unetim email-om: " + registerUserDTO.getEmail());
        if (userRepository.existsByIndexNumber(registerUserDTO.getIndexNumber()))
            exceptionMessages.add("Vec postoji korisnik sa unetim brojem indeksa: " + registerUserDTO.getIndexNumber());

        CVBuilderUtils.throwExceptionIfHasMessages(exceptionMessages);
    }

    private void checkPreconditionsForAdminRegisterUser(AdminUserRegisterDTO adminUserRegisterDTO) {
        List<String> exceptionMessages = new LinkedList<>();
        if (userRepository.existsByUsername(adminUserRegisterDTO.getUsername()))
            exceptionMessages.add("Vec postoji korisnik sa unetim korisnickim imenom: " + adminUserRegisterDTO.getUsername());
        if (userRepository.existsByEmail(adminUserRegisterDTO.getEmail()))
            exceptionMessages.add("Vec postoji korisnik sa unetim email-om: " + adminUserRegisterDTO.getEmail());
        if (userRepository.existsByIndexNumber(adminUserRegisterDTO.getIndexNumber()))
            exceptionMessages.add("Vec postoji korisnik sa unetim brojem indeksa: " + adminUserRegisterDTO.getIndexNumber());
        if (adminUserRegisterDTO.getRole() == null)
            exceptionMessages.add("Korisnik mora imati dodeljenju rolu");
        CVBuilderUtils.throwExceptionIfHasMessages(exceptionMessages);
    }

    private void checkPreconditionsForUpdate(UpdateUserDTO updateUserDTO) {
        List<String> exceptionMessages = new LinkedList<>();
        Optional<User> user = userRepository.findById(updateUserDTO.getId());
        if (!user.isPresent())
            exceptionMessages.add("Ne postoji korsinik sa unetim ID-om: " + updateUserDTO.getId());
        else {
            if (!passwordEncoder.matches(updateUserDTO.getOldPassword(), user.get().getPassword()))
                exceptionMessages.add("Sifra korisnika se ne podudara");
            if (userRepository.existsByUsernameAndIdNot(updateUserDTO.getUsername(), updateUserDTO.getId()))
                exceptionMessages.add("Vec postoji korisnik sa unetim korisnickim imenom: " + updateUserDTO.getUsername());
            if (userRepository.existsByEmailAndIdNot(updateUserDTO.getEmail(), updateUserDTO.getId()))
                exceptionMessages.add("Vec postoji korisnik sa unetim email-om: " + updateUserDTO.getEmail());
            if (userRepository.existsByIndexNumberAndIdNot(updateUserDTO.getIndexNumber(), updateUserDTO.getId()))
                exceptionMessages.add("Vec postoji korisnik sa unetim brojem indeksa: " + updateUserDTO.getIndexNumber());
            if ((updateUserDTO.getUsername() != null && !updateUserDTO.getUsername().isEmpty())
                    && (updateUserDTO.getUsername().length() < 3 || updateUserDTO.getUsername().length() > 255))
                exceptionMessages.add("Korisnicko ime mora imati izmedju 3 i 255 karaktera");
            if ((updateUserDTO.getPassword() != null && !updateUserDTO.getPassword().isEmpty())
                    && (updateUserDTO.getPassword().length() < 5 || updateUserDTO.getPassword().length() > 255))
                exceptionMessages.add("Lozinka mora imati izmedju 5 i 255 karaktera");
            if (updateUserDTO.getPassword() != null && !updateUserDTO.getPassword().isEmpty()
                    && (updateUserDTO.getOldPassword().isEmpty() || updateUserDTO.getOldPassword() == null))
                exceptionMessages.add("Niste uneli prethodnu lozinku");
            if (updateUserDTO.getPassword() != null && !updateUserDTO.getPassword().isEmpty()
                    && (updateUserDTO.getOldPassword() != null && !updateUserDTO.getOldPassword().isEmpty() && user.isPresent() && !passwordEncoder.matches(updateUserDTO.getPassword(), user.get().getPassword())))
                exceptionMessages.add("Stara lozinka nije dobra");
            if ((updateUserDTO.getEmail() != null && !updateUserDTO.getEmail().isEmpty())
                    && (updateUserDTO.getEmail().length() < 3 || updateUserDTO.getUsername().length() > 255))
                exceptionMessages.add("Email mora imati izmedju 3 i 255 karaktera");
            if ((updateUserDTO.getEmail() != null && !updateUserDTO.getEmail().isEmpty())
                    && !EmailValidator.getInstance().isValid(updateUserDTO.getEmail()))
                exceptionMessages.add("Email nije u ispravnom formatu");
        }
        CVBuilderUtils.throwExceptionIfHasMessages(exceptionMessages);
    }

    protected void checkPreconditionsForAdminUpdate(AdminUserUpdateDTO adminUserUpdateDTO) {
        List<String> exceptionMessages = new LinkedList<>();
        Optional<User> user = userRepository.findById(adminUserUpdateDTO.getId());
        if (!user.isPresent())
            exceptionMessages.add("Ne postoji korsinik sa unetim ID-om: " + adminUserUpdateDTO.getId());
        else {
            if (userRepository.existsByUsernameAndIdNot(adminUserUpdateDTO.getUsername(), adminUserUpdateDTO.getId()))
                exceptionMessages.add("Vec postoji korisnik sa unetim korisnickim imenom: " + adminUserUpdateDTO.getUsername());
            if (userRepository.existsByEmailAndIdNot(adminUserUpdateDTO.getEmail(), adminUserUpdateDTO.getId()))
                exceptionMessages.add("Vec postoji korisnik sa unetim email-om: " + adminUserUpdateDTO.getEmail());
            if (userRepository.existsByIndexNumberAndIdNot(adminUserUpdateDTO.getIndexNumber(), adminUserUpdateDTO.getId()))
                exceptionMessages.add("Vec postoji korisnik sa unetim brojem indeksa: " + adminUserUpdateDTO.getIndexNumber());
            if ((adminUserUpdateDTO.getUsername() != null && !adminUserUpdateDTO.getUsername().isEmpty())
                    && (adminUserUpdateDTO.getUsername().length() < 3 || adminUserUpdateDTO.getUsername().length() > 255))
                exceptionMessages.add("Korisnicko ime mora imati izmedju 3 i 255 karaktera");
            if ((adminUserUpdateDTO.getPassword() != null && !adminUserUpdateDTO.getPassword().isEmpty())
                    && (adminUserUpdateDTO.getPassword().length() < 5 || adminUserUpdateDTO.getPassword().length() > 255))
                exceptionMessages.add("Lozinka mora imati izmedju 5 i 255 karaktera");
            if ((adminUserUpdateDTO.getEmail() != null && !adminUserUpdateDTO.getEmail().isEmpty())
                    && (adminUserUpdateDTO.getEmail().length() < 3 || adminUserUpdateDTO.getUsername().length() > 255))
                exceptionMessages.add("Email mora imati izmedju 3 i 255 karaktera");
            if ((adminUserUpdateDTO.getEmail() != null && !adminUserUpdateDTO.getEmail().isEmpty())
                    && !EmailValidator.getInstance().isValid(adminUserUpdateDTO.getEmail()))
                exceptionMessages.add("Email nije u ispravnom formatu");
            if (adminUserUpdateDTO.getRole() != null
                    && adminUserUpdateDTO.getRole().getId() != null
                    && roleRepository.existsById(adminUserUpdateDTO.getRole().getId()))
                exceptionMessages.add("Rola dodeljenja korisniku ne postoji");
        }
        CVBuilderUtils.throwExceptionIfHasMessages(exceptionMessages);
    }

    private void checkPreconditionsForDeactivate(Long id) {
        List<String> exceptionMessages = new LinkedList<>();
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent())
            exceptionMessages.add("Ne postoji korisnik sa prosledjenim Id-em : " + id);
        if (user.isPresent() && !user.get().isActivated())
            exceptionMessages.add("Korisnik sa prosledjenim Id-em " + id + " je vec deaktiviran");
        CVBuilderUtils.throwExceptionIfHasMessages(exceptionMessages);
    }
}
