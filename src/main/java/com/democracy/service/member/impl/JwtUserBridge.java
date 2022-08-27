package com.democracy.service.member.impl;

import com.democracy.common.annotation.Bridge;
import com.democracy.service.member.dao.JwtUserRepository;
import com.democracy.service.member.dto.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

@Bridge
public class JwtUserBridge {

    @Autowired
    private JwtUserRepository jwtUserRepository;


    //save 필요

    public User select(String userId) {
        if(userId == "" || userId.equals(null)){
            throw new IllegalArgumentException("아이디가 입력이 되자 않았습니다.");
        }

        Optional<User> op = jwtUserRepository.findById(userId);

        User user = op.orElse(null);



        return user;
    }

    public int insert(User user) {
        jwtUserRepository.save(user);
        return 0;
    }


}
