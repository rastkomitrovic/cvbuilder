package com.fon.bg.ac.rs.cvbuilder.mapper;

import com.fon.bg.ac.rs.cvbuilder.dto.UserDTO;
import com.fon.bg.ac.rs.cvbuilder.entity.User;
import com.fon.bg.ac.rs.cvbuilder.mapper.generic.GenericMapper;
import com.fon.bg.ac.rs.cvbuilder.util.CVBuilderUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserMapper extends GenericMapper<User, UserDTO> {

    @Resource
    private RoleMapper roleMapper;

    @Resource
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    protected UserDTO toDTOTransformation(User object) {
        UserDTO user = new UserDTO();
        user.setId(object.getId());
        user.setUsername(object.getUsername());
        user.setPassword(object.getPassword());
        user.setFirstName(object.getFirstName());
        user.setLastName(object.getLastName());
        user.setEmail(object.getEmail());
        user.setIndexNumber(object.getIndexNumber());
        user.setActivated(object.isActivated());
        if (CVBuilderUtils.isLazyEntityInitialized(object.getRole()))
            user.setRole(roleMapper.toDTO(object.getRole()));
        return user;
    }

    @Override
    protected User toDAOTransformation(UserDTO object) {
        User user = new User();
        user.setId(object.getId());
        user.setUsername(object.getUsername());
        user.setPassword(passwordEncoder.encode(object.getPassword()));
        user.setFirstName(object.getFirstName());
        user.setLastName(object.getLastName());
        user.setEmail(object.getEmail());
        user.setIndexNumber(object.getIndexNumber());
        user.setActivated(object.isActivated());
        user.setRole(roleMapper.toDAO(object.getRole()));
        return user;
    }

}
