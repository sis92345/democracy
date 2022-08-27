package com.democracy.service.member.impl;

import com.democracy.service.member.dao.CustomUserDetailsService;
import com.democracy.service.member.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsServiceImpl implements CustomUserDetailsService {
//
//    private final JwtUserRepository jwtUserRepository;

    @Autowired
    private JwtUserBridge jwtUserBridge;

//    public CustomUserDetailsServiceImpl(JwtUserRepository jwtUserRepository) {
//        this.jwtUserRepository = jwtUserRepository;
//    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = jwtUserBridge.select(username);


        if (user == null) {
            throw new UsernameNotFoundException("User not authorized.");
        }

        return user;
    }
}
