package com.democracy.jwt;

import com.democracy.config.StandardSpringTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class createJwtTest extends StandardSpringTest {


    @Autowired
    private JwtUtils utils;


    @Test
    @DisplayName( "jwt 만들기" )
    public void SAVE_MEMBER_TEST() {

        String token = utils.createToken("tetet",10L);

        System.out.println(token);

    }


}
