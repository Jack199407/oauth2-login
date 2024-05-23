package com.example.google.service;

import com.example.google.dto.UserPrincipal;
import com.example.google.repository.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class CustomUserDetailsService implements UserDetailsService {
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        // 此处按照email查询数据库
        User user = null;
        if (Objects.equals(email, "admin@gmail.com")) {
            user = new User();
            user.setName("admin@gmail.com");
            user.setId(1L);
            // spring security的UsernamePasswordAuthenticationFilter会对密码做加密校验
            // 此处为123456的加密字符串
            user.setPassword("$2a$10$U0PL5/4tmkUzI7aTi/1VJew7DBoK44OwWhwnXFGwet8wEN/Kyvlg6");
        }
        if (user == null) {
            throw new UsernameNotFoundException("User not found with email : " + email);
        }
        return UserPrincipal.create(user);
    }
}
