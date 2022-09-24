package com.fon.bg.ac.rs.cvbuilder.mapper;

import com.fon.bg.ac.rs.cvbuilder.dto.user.*;
import com.fon.bg.ac.rs.cvbuilder.entity.Role;
import com.fon.bg.ac.rs.cvbuilder.entity.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserMapper {

    @Resource
    private RoleMapper roleMapper;

    @Resource
    private BCryptPasswordEncoder passwordEncoder;

    public FindUserDTO toFindUserDTO(User user) {
        if (user == null)
            return null;
        FindUserDTO findUserDTO = new FindUserDTO();
        findUserDTO.setId(user.getId());
        findUserDTO.setUsername(user.getUsername());
        findUserDTO.setFirstName(user.getFirstName());
        findUserDTO.setLastName(user.getLastName());
        findUserDTO.setIndexNumber(user.getIndexNumber());
        findUserDTO.setActivated(user.isActivated());
        findUserDTO.setRole(roleMapper.toRoleDTO(user.getRole()));
        return findUserDTO;
    }

    public User toDAORegisterUser(RegisterUserDTO registerUserDTO, Role role) {
        User user = new User();
        user.setId(0L);
        user.setUsername(registerUserDTO.getUsername());
        user.setPassword(passwordEncoder.encode(registerUserDTO.getPassword()));
        user.setFirstName(registerUserDTO.getFirstName());
        user.setLastName(registerUserDTO.getLastName());
        user.setEmail(registerUserDTO.getEmail());
        user.setIndexNumber(registerUserDTO.getIndexNumber());
        user.setActivated(true);
        user.setRole(role);
        return user;
    }

    public User toDAO(AdminUserRegisterDTO adminUserRegisterDTO) {
        User user = new User();
        user.setId(0L);
        user.setUsername(adminUserRegisterDTO.getUsername());
        user.setPassword(passwordEncoder.encode(adminUserRegisterDTO.getPassword()));
        user.setFirstName(adminUserRegisterDTO.getFirstName());
        user.setLastName(adminUserRegisterDTO.getLastName());
        user.setEmail(adminUserRegisterDTO.getEmail());
        user.setIndexNumber(adminUserRegisterDTO.getIndexNumber());
        user.setActivated(true);
        user.setRole(roleMapper.toDAO(adminUserRegisterDTO.getRole()));
        return user;
    }

    public void mapToDAOForUserUpdate(User user, UpdateUserDTO updateUserDTO) {
        if (updateUserDTO.getUsername() != null && !updateUserDTO.getUsername().isEmpty())
            user.setUsername(updateUserDTO.getUsername());
        if (updateUserDTO.getPassword() != null && !updateUserDTO.getPassword().isEmpty()
                && updateUserDTO.getOldPassword() != null && !updateUserDTO.getOldPassword().isEmpty()
                && passwordEncoder.matches(updateUserDTO.getOldPassword(), user.getPassword()))
            user.setPassword(passwordEncoder.encode(updateUserDTO.getPassword()));
        if (updateUserDTO.getFirstName() != null && !updateUserDTO.getFirstName().isEmpty())
            user.setFirstName(updateUserDTO.getFirstName());
        if (updateUserDTO.getLastName() != null && !updateUserDTO.getLastName().isEmpty())
            user.setLastName(updateUserDTO.getLastName());
        if (updateUserDTO.getEmail() != null && !updateUserDTO.getEmail().isEmpty())
            user.setEmail(updateUserDTO.getEmail());
        if (updateUserDTO.getIndexNumber() != null && !updateUserDTO.getIndexNumber().isEmpty())
            user.setIndexNumber(updateUserDTO.getIndexNumber());
    }

    public void mapToDAOForAdminUserUpdate(User user, AdminUserUpdateDTO adminUserUpdateDTO) {
        if (adminUserUpdateDTO.getUsername() != null && !adminUserUpdateDTO.getUsername().isEmpty())
            user.setUsername(adminUserUpdateDTO.getUsername());
        if (adminUserUpdateDTO.getPassword() != null && !adminUserUpdateDTO.getPassword().isEmpty())
            user.setPassword(passwordEncoder.encode(adminUserUpdateDTO.getPassword()));
        if (adminUserUpdateDTO.getFirstName() != null && !adminUserUpdateDTO.getFirstName().isEmpty())
            user.setFirstName(adminUserUpdateDTO.getFirstName());
        if (adminUserUpdateDTO.getLastName() != null && !adminUserUpdateDTO.getLastName().isEmpty())
            user.setLastName(adminUserUpdateDTO.getLastName());
        if (adminUserUpdateDTO.getEmail() != null && !adminUserUpdateDTO.getEmail().isEmpty())
            user.setEmail(adminUserUpdateDTO.getEmail());
        if (adminUserUpdateDTO.getIndexNumber() != null && !adminUserUpdateDTO.getIndexNumber().isEmpty())
            user.setIndexNumber(adminUserUpdateDTO.getIndexNumber());
        if (adminUserUpdateDTO.getRole() != null)
            user.setRole(roleMapper.toDAO(adminUserUpdateDTO.getRole()));
    }

}
