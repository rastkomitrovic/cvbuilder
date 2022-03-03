package com.fon.bg.ac.rs.cvbuilder.repository;

import com.fon.bg.ac.rs.cvbuilder.entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role,Long> {

    boolean existsByName(String name);

    boolean existsByNameAndIdNot(String name, Long id);
}
