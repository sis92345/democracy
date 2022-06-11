package com.democracy;

import com.democracy.sample.test.TestRepository;
import com.democracy.util.ApplicationPropertiesUtils;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@SpringBootTest
@ExtendWith( SpringExtension.class )
class DemocracyApplicationTests {
		
		static {
				
				Properties testEnv = new Properties();
				
				try {
						
						InputStream testProperty = DemocracyApplicationTests.class.getClassLoader().getResourceAsStream("application-test.properties");
						
						testEnv.load( testProperty );
						ApplicationPropertiesUtils.setEnvProperties( testEnv );
						ApplicationPropertiesUtils.initEnvProperties();
				}
				catch ( IOException e ) {
						e.printStackTrace();
				}
		}
		
		@PostConstruct
		void contextLoads() {
				
				System.out.println( "TestRun" );
		
		}
		
		
		@Autowired
		TestRepository testRepository;
		
		@Test
		public void jpaTest() {
				
				System.out.println( testRepository.findAll() );
		}
}
