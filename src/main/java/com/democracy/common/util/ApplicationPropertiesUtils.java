package com.democracy.common.util;

import lombok.Setter;
import org.springframework.util.StringUtils;

import java.util.Properties;

/**
 * Application Property 설정
 * */
@Setter
public class ApplicationPropertiesUtils {
		
		private static final String APPLICATION_ENV_PATH = "/env/";
		
		static Properties envProperties = new Properties();
		
		static {
				
				try {
						
						// 개발 환경에 맞는 프로퍼티를 로드합니다.
						String env = System.getProperty( "spring.profiles.active" , "local" );
						
						String envFilePath = APPLICATION_ENV_PATH + env + "/application-" + env + ".properties";
						
						envProperties.load( ApplicationPropertiesUtils.class.getResourceAsStream( envFilePath ) );
						
						initEnvProperties();
				}
				catch ( Exception e ) {}
				
		}
		
		public ApplicationPropertiesUtils() {}
		
		public static void initEnvProperties() {
				
				for ( Object key : envProperties.keySet() ) {
						
						System.setProperty( String.valueOf( key ), String.valueOf( envProperties.get( key ) ) );
				}
		}
		
		public static void setEnvProperties ( Properties properties ) {
				
				envProperties = properties;
		}
		
		public static String getValue(String key ) {
				return 	envProperties == null ? "" : envProperties.getProperty(key);
		}
		
		
		public static String getValue(String key , String defaultVal ) {
				String property = getValue( key );
				return StringUtils.isEmpty( property ) ? defaultVal : property;
		}
		
		
}
