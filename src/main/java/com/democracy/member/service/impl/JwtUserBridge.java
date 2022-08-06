package com.democracy.member.service.impl;

import com.democracy.common.annotation.Bridge;
import com.democracy.member.service.JwtUserRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Bridge
public class JwtUserBridge {

    @Autowired
    private JwtUserRepository jwtUserRepository;


    //save 필요


}
