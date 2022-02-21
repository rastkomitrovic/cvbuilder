package com.fon.bg.ac.rs.cvbuilder.service.impl;

import com.fon.bg.ac.rs.cvbuilder.dto.UserDTO;
import com.fon.bg.ac.rs.cvbuilder.mapper.UserMapper;
import com.fon.bg.ac.rs.cvbuilder.repository.UserRepository;
import com.fon.bg.ac.rs.cvbuilder.service.generic.GenericPagingService;
import com.fon.bg.ac.rs.cvbuilder.util.SearchParam;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements GenericPagingService<UserDTO,Long> {

    @Resource
    private UserRepository repository;

    @Resource
    private UserMapper mapper;

    @Override
    public Page<UserDTO> findPage(Pageable pageable) {
        return repository.findAll(pageable).map(it -> mapper.toDTO(it));
    }

    @Override
    public Page<UserDTO> searchPage(Pageable pageable, List<SearchParam> searchParams) {
        return null;
    }

    @Override
    public UserDTO save(UserDTO object) {
        return mapper.toDTO(repository.save(mapper.toDAO(object)));
    }

    @Override
    public UserDTO update(UserDTO object) {
        return mapper.toDTO(repository.save(mapper.toDAO(object)));
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<UserDTO> getAll() {
        return mapper.toDTOList(repository.findAll());
    }

    @Override
    public Optional<UserDTO> findById(Long id) {
        return repository.findById(id).map(it -> mapper.toDTO(it));
    }
}
