package com.democracy.service.member.impl;

import com.democracy.service.member.MemberService;
import com.democracy.service.member.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {

    @Autowired
    private JwtUserBridge jwtUserBridge;
    @Override
    public User select(String userId) {
        return jwtUserBridge.select(userId);
    }
    @Override
    public int insert(User user) {
        jwtUserBridge.insert(user);
        return 0;
    }
}