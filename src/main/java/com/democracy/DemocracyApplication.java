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
				System.out.println( "ENV : " + ApplicationPropertiesUtils.getValue( "spring.profiles.active" , "local" ) );
				System.out.println( "timeout : " + ApplicationPropertiesUtils.getValue( "local.app.jwt.expire-timeout" , "40" ) );
				System.out.println( "==============================================================\n\n"  );
				
				SpringApplication democracyApp = new SpringApplication( DemocracyApplication.class );
				democracyApp.setBanner( new DemocracyBanner() );
				democracyApp.run( args );
		}
}
