package com.democracy;

import com.democracy.config.StandardSpringTest;
import com.democracy.member.dto.User;
import com.democracy.member.service.JwtUserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

class JPAConnectionTest extends StandardSpringTest {

		@Autowired
        JwtUserRepository jwtUserRepository;


		@Test
		@DisplayName( "member 테이블 저장 테스트" )
		public void SAVE_MEMBER_TEST() {
            Optional<User> op = jwtUserRepository.findById("admin");
			System.out.println(op);
            User user = op.orElse(null);
            System.out.println(user);

		}
}
