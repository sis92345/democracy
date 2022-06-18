package com.democracy;

import com.democracy.config.StandardSpringTest;
import com.democracy.member.service.MemberRepository;
import com.democracy.member.dto.Member;
import com.democracy.member.service.MemberService;
import com.democracy.sample.test.TestData;
import com.democracy.sample.test.TestRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;
import java.util.List;

class JPAConnectionTest extends StandardSpringTest {
		
		@Autowired
		TestRepository testRepository;
		
		@Autowired
		MemberRepository memberRepository;
		
		@Autowired MemberService memberService;
		
		
		
		@Test
		@DisplayName( "JPA 연결이 잘 되는지 테스트" )
		public void JPA_CONNECTION_TEST() {
				
				List<TestData> testDataList = testRepository.findAll();
				TestData testData = testDataList.get( 0 );
				
				System.out.println( "JPA로 가져온 DB 데이터!!!!" + testData.getUserName() );
				
				Assertions.assertEquals( testData.getUserName() , "AN" , ()->{
						
						if ( testDataList.size() <= 0 ) {
								
								return "테스트 데이터가 비어있습니다. DB CONNECTION이 정상이라면 JPA 설정에 문제가 존재합니다.";
						}
						else if ( !testData.getUserName().equals( "AN" ) ) {
								return "DB 값이 바뀌어서 실패한 경우 입니다. 정상적인 결과입니다. \n값 : " + testData.getUserName() ;
						}
						
						
						return  "";
				});
				
		}
		
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
