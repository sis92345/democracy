package com.democracy;

import com.democracy.config.AppConfig;
import com.democracy.config.DemocracyBanner;
import com.democracy.common.util.ApplicationPropertiesUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@ComponentScan(basePackages = {"com"})
@Import( AppConfig.class )
public class DemocracyApplication {
		
		public static void main( String[] args ) {
				
				String profile = System.getProperty( "spring.profiles.active" , "local" );
				
				System.setProperty( "spring.profiles.active" , profile );
				
				ApplicationPropertiesUtils.initEnvProperties();
				
				System.out.println( "=================== Democracy Server INFO ==================="  );
				System.out.println( "ENV : " + System.getProperty( "env.status" ) );
				System.out.println( "==============================================================\n\n"  );
				
				SpringApplication democracyApp = new SpringApplication( DemocracyApplication.class );
				democracyApp.setBanner( new DemocracyBanner() );
				democracyApp.run( args );
		}
}
