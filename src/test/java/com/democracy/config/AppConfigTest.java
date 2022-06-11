package com.democracy.config;

import com.democracy.util.ApplicationPropertiesUtils;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.ImportResource;
import org.springframework.scheduling.annotation.EnableAsync;

import java.io.IOException;
import java.util.Properties;

@EnableAspectJAutoProxy ( proxyTargetClass=true)
@EnableAsync
@ComponentScan( basePackages = { "com.democracy", }, useDefaultFilters = true )
public class AppConfigTest {


		static {

			    Properties testEnv = new Properties();
				
			    try {
						testEnv.load( AppConfigTest.class.getClassLoader().getResourceAsStream("/env/test/application-test.properties"));
						ApplicationPropertiesUtils.setEnvProperties( testEnv );
						ApplicationPropertiesUtils.initEnvProperties();
				}
				catch ( IOException e ) {
						e.printStackTrace();
				}
		}
		
		public AppConfigTest() {}

}