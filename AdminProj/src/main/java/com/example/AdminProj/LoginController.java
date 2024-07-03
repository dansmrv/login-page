package com.example.AdminProj;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@Controller
public class LoginController{

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/admin")
    public String adminPage(){
        return "admin";
    }

    @GetMapping("/user")
    public String userPage(){
        return "user";
    }

    @RequestMapping("/default")
    public String defaultLoginPage(Authentication auth) {
        Set<String> roles = AuthorityUtils.authorityListToSet(auth.getAuthorities());
        if (roles.contains("ROLE_ADMIN")){
            return "redirect:/admin";
        }
        if (roles.contains("ROLE_USER")){
            return "redirect:/user";
        }
        return "redirect:/login";
    }

}
