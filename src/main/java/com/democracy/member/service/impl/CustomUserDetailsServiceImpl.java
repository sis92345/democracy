package com.democracy.member.service.impl;

import com.democracy.member.dto.User;
import com.democracy.member.service.CustomUserDetailsService;
import com.democracy.member.service.JwtUserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsServiceImpl implements CustomUserDetailsService {

    private final JwtUserRepository jwtUserRepository;

    public CustomUserDetailsServiceImpl(JwtUserRepository jwtUserRepository) {
        this.jwtUserRepository = jwtUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> op = jwtUserRepository.findById(username);

        User user = op.orElse(null);


        if (user == null) {
            throw new UsernameNotFoundException("User not authorized.");
        }

        return user;
    }
}
