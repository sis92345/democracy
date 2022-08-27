package com.democracy;

import com.democracy.config.StandardSpringTest;
import com.democracy.redis.RedisService;
import com.democracy.web.LoginController;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

@AutoConfigureMockMvc
class MemberControllerTest extends StandardSpringTest {
		@Autowired
		LoginController loginController;


		@Autowired
		WebApplicationContext context;

		@Autowired
		public MockMvc mockMvc;
		@Autowired
		RedisService redisService;



		@Test
		@DisplayName( "member 테이블 저장 테스트" )
		public void SAVE_MEMBER_TEST() throws Exception{
			MultiValueMap<String, String> param = new LinkedMultiValueMap<>();
			param.add("id_user", "user123");
			param.add("pw_user","123");
			param.add("nm_user","asdqw");

			ResultActions resultActions =mockMvc.perform(MockMvcRequestBuilders.post("/api/auth/join")
					.params(param)
			);


			resultActions.andExpect(MockMvcResultMatchers.status().isOk())
					.andDo(MockMvcResultHandlers.print());


		}



	@Test
	@DisplayName( "member 테이블 저장 테스트" )
	public void Redis_test_Sample() {
		redisService.setValues("test","test");

		System.out.println(redisService.getValues("test"));
	}
}
