package com.democracy.common.util;

import org.slf4j.MDC;
import org.springframework.util.StringUtils;

/**
 * 로그 관련 MDC 유틸
 * */
public class MDCUtils {
		
		public static void put ( String key , String value ) {
				
				MDC.put( key , value );
		}
		
		public static String  get( String key ) {
				return MDCUtils.get( key , "" );
		}
		
		public static String get( String key , String defaultVal ) {
				
				String value = MDC.get( key );
				
				if ( !StringUtils.hasText( value ) ) {
						
						return defaultVal;
				}
				
				return value;
		}
		
		public static void remove ( String key ) {
				
				if ( !StringUtils.hasText( key ) ) {
						return;
				}
				
				MDC.remove( key );
		}
		
		public static void clear() {
				MDC.clear();
		}
}
