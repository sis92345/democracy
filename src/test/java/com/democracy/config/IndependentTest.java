package com.democracy.config;

/**
 * 스프링을 사용하지 않는 표준 테스트 입니다.
 * Spring과 무관하게 동작합니다.
 * 실제 테스트에서 이 클래스를 상속받아 테스트를 진행할 수 있습니다.
 *
 * @author ted
 * @version 1.0 2022.06.11 ted : 최초 생성
 * */
public class IndependentTest {
		
		public IndependentTest(){
				
				System.out.println( "Spring과 무관한 독립 테스트" );
		}
}
