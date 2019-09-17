package com.test.sp.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.sp.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);


    List<User> findByIdIn(List<Long> userIds);


    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);


	Optional<User> findByName(String name);


	Optional<User> findByIdOrName(String idOrname, String idOrname2);
}