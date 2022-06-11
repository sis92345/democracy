package com.democracy;

import com.democracy.config.DemocracyBanner;
import com.democracy.util.ApplicationPropertiesUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class DemocracyApplication extends SpringBootServletInitializer {
		
		public static void main( String[] args ) {
				
				String profile = System.getProperty( "spring.profiles.active" , "local" );
				
				System.setProperty( "spring.profiles.active" , profile );
				
				ApplicationPropertiesUtils.initEnvProperties();
				
				System.out.println( "=================== Democracy Server Start ==================="  );
				System.out.println( "ENV : " + System.getProperty( "env.status" ) );
				System.out.println( "=============================================================="  );
				System.out.println();
				System.out.println();
				
				SpringApplication democracyApp = new SpringApplication( DemocracyApplication.class );
				democracyApp.setBanner( new DemocracyBanner() );
				democracyApp.run( args );
		}
		
		// WAR로 빌드 시 필요
		@Override
		protected SpringApplicationBuilder configure( SpringApplicationBuilder applicationBuilder ) {
				
				ApplicationPropertiesUtils.initEnvProperties();
				
				return applicationBuilder.sources( DemocracyApplication.class );
				
		}
}
