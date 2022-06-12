package com.democracy.config;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

/**
 * 스프링을 사용하는 표준 테스트 입니다.
 * 모든 Spring의 Bean을 등록하며 application-test.properties의 프로퍼티를 모두 load 합니다.
 * 실제 테스트에서 이 클래스를 상속받아 테스트를 진행할 수 있습니다.
 *
 * @author ted
 * @version 1.0 2022.06.11 ted : 최초 생성
 * */
@SpringBootTest(classes = { AppConfigTest.class } )
@ExtendWith( SpringExtension.class )
public class StandardSpringTest {
		
		
		public StandardSpringTest() {
				
				System.out.println( "Spring 연동 테스트" );
		}
}
