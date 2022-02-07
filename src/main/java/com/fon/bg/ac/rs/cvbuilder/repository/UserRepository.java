package com.fon.bg.ac.rs.cvbuilder.repository;

import com.fon.bg.ac.rs.cvbuilder.entity.User;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User,Long> {
}
