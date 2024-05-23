package com.example.google.controller;

import com.example.google.annotation.CurrentUser;
import com.example.google.dto.UserPrincipal;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @GetMapping("/get")
    @PreAuthorize("hasRole('USER')") /*校验当前用户是否用有USER权限*/
    public UserPrincipal getCurrentUser(@CurrentUser UserPrincipal userPrincipal/*可通过注解直接获取到当前用户信息，实
    际上spring security会把用户信息放在springContextHolder中，通过注解获取比较优雅*/) {
        return userPrincipal;
    }

    @GetMapping("/free")
    public String free() {
        return "free";
    }
}
