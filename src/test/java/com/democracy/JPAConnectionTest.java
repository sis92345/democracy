package com.democracy;

import com.democracy.config.StandardSpringTest;
import com.democracy.redis.RedisService;
import com.democracy.service.member.MemberService;
import com.democracy.service.member.dto.User;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

class JPAConnectionTest extends StandardSpringTest {

		@Autowired
        private MemberService memberService;

		@Autowired
		RedisService redisService;


		@Test
		@DisplayName( "member 테이블 저장 테스트" )
		public void SAVE_MEMBER_TEST() {
            User user = memberService.select("admin");
            System.out.println(user);

		}



	@Test
	@DisplayName( "member 테이블 저장 테스트" )
	public void Redis_test_Sample() {
		redisService.setValues("test","test");

		System.out.println(redisService.getValues("test"));
	}
}
