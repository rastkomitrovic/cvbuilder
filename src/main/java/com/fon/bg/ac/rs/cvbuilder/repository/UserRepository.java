package com.fon.bg.ac.rs.cvbuilder.repository;

import com.fon.bg.ac.rs.cvbuilder.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends PagingAndSortingRepository<User, Long> {

    @Query("Select u from User u where concat(u.firstName,' ', u.lastName) like concat('%',:param,'%') or u.email like concat('%',:param,'%') or u.username like concat('%',:param,'%')")
    Page<User> searchPage(Pageable pageable, String param);

    boolean existsByUsername(String username);
    boolean existsByEmail(String email);
    boolean existsByIndexNumber(String indexNumber);
    boolean existsByUsernameAndIdNot(String username, Long userId);
    boolean existsByEmailAndIdNot(String email,Long userId);
    boolean existsByIndexNumberAndIdNot(String email, Long userId);
}
