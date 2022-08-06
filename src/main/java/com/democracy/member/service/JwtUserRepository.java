package com.democracy.member.service;

import com.democracy.member.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JwtUserRepository extends JpaRepository<User,String> {

    //구현 해야 함


}
