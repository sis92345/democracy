package com.democracy.common.util;

import org.slf4j.MDC;
import org.springframework.util.StringUtils;

/**
 * 로그 관련 MDC 유틸 : MDC를 이용해서 Log를 커스터마이징 하기위해 사용
 * MDC는 Filter에서 무조건 clear시키고 있음 ( 2022.06.19 )
 *
 * @author ted
 * @version 2022.06.19 1.1 ted 최초 생성
 * */
public class MDCUtils {
		
		/**
		 * MDC에 값을 넣습니다.
		 *
		 * @author ted
		 * @param key - Log에서 받을 Key, Logger에서 %X로 접근 가능
		 * @param value - Log로 남길 Value
		 * */
		public static void put ( String key , String value ) {
				
				MDC.put( key , value );
		}
		
		/**
		 * MDC에서 Key로 값을 얻습니다.
		 *
		 * @author ted
		 * @param key - 조회 KEY
		 * @return {string|""} - 값이 없으면 ""를 반환
		 * */
		public static String  get( String key ) {
				return MDCUtils.get( key , "" );
		}
		
		/**
		 * MDC에서 Key로 값을 얻습니다.
		 *
		 * @author ted
		 * @param key -  조회 KEY
		 * @param defaultVal - Key로 조회한 값이 null이면 받을 값
		 * */
		public static String get( String key , String defaultVal ) {
				
				String value = MDC.get( key );
				
				if ( !StringUtils.hasText( value ) ) {
						
						return defaultVal;
				}
				
				return value;
		}
		
		/**
		 * MDC에서 해당 Key를 삭제합니다.
		 *
		 * @author ted
		 * @param key - 식제할 KEY
		 * */
		public static void remove ( String key ) {
				
				if ( !StringUtils.hasText( key ) ) {
						return;
				}
				
				MDC.remove( key );
		}
		
		/**
		 * MDC 초기화
		 *
		 * @author ted
		 * */
		public static void clear() {
				MDC.clear();
		}
}
