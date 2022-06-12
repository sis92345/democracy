package com.democracy;

import com.democracy.config.StandardSpringTest;
import com.democracy.sample.test.TestData;
import com.democracy.sample.test.TestRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

class JPAConnectionTest extends StandardSpringTest {
		
		@Autowired
		TestRepository testRepository;
		
		@Test
		@DisplayName( "JPA 연결이 잘 되는지 테스트" )
		public void JPA_CONNECTION_TEST() {
				
				List<TestData> testDataList = testRepository.findAll();
				TestData testData = testDataList.get( 0 );
				
				System.out.println( "JPA로 가져온 DB 데이터!!!!" + testData.getUSER_NAME() );
				
				Assertions.assertEquals( testData.getUSER_NAME() , "AN" );
				
		}
}
