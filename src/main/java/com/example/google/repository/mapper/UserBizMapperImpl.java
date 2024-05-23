package com.example.google.repository.mapper;

import com.example.google.repository.model.User;
import org.springframework.stereotype.Component;

import java.util.Optional;
@Component
public class UserBizMapperImpl implements UserBizMapper{
    @Override
    public Optional<User> findByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public Boolean existsByEmail(String email) {
        return null;
    }

    @Override
    public User save(User user) {
        return null;
    }
}
