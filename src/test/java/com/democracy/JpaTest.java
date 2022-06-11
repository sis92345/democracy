package com.democracy;

import com.democracy.sample.test.TestData;
import com.democracy.sample.test.TestRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


public class JpaTest extends DemocracyApplicationTests{

		@Autowired
		TestRepository testRepository;
		
		@Test
		public void jpaTest() {
				
				System.out.println( testRepository.findAll() );
		}
}
