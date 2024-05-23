package com.example.google.repository.mapper;

import com.example.google.repository.model.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserBizMapper {

    Optional<User> findByEmail(String email);

    Boolean existsByEmail(String email);

    User save(User user);

}
