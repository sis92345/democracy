package com.democracy.member.service.impl;

import com.democracy.member.service.CustomUserDetailsService;
import com.democracy.member.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsServiceImpl implements CustomUserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        UserVO user = userService.select(username);

//        if (user == null) {
//            throw new UsernameNotFoundException("User not authorized.");
//        }

//        return user;
        return null;
    }
}
