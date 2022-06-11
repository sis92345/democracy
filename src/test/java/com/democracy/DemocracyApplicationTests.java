package com.democracy;

import com.democracy.util.ApplicationPropertiesUtils;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

@SpringBootTest
@RunWith( SpringJUnit4ClassRunner.class )
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
		
}
