package com.democracy;

import com.democracy.config.StandardSpringTest;
import com.democracy.member.service.MemberRepository;
import com.democracy.member.dto.Member;
import com.democracy.member.service.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

class JPAConnectionTest extends StandardSpringTest {
		
		@Autowired
		MemberRepository memberRepository;
		
		@Autowired MemberService memberService;
		
		@Test
		@DisplayName( "member 테이블 저장 테스트" )
		public void SAVE_MEMBER_TEST() {
				
				Member member = new Member();
				member.setId( "asd1234" );
				member.setInputDate( LocalDate.now() );
				member.setEmail( "test@example.co.kr" );
				member.setJoinType( 0 );
				member.setPassword( "test1" );
				
				member = memberService.save( member );
				
				System.out.println( member );
		}
}
