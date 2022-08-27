package com.democracy.service.member;

import com.democracy.service.member.dto.User;

public interface MemberService {

    public User select(String userId);
    public int insert(User user);
}
