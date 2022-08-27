package com.democracy.service.member.dao;

import com.democracy.service.member.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JwtUserRepository extends JpaRepository<User,String> {

    //구현 해야 함


}
