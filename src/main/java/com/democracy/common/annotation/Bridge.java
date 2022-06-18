package com.democracy.common.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 브릿지 컴포넌트 정의용
 * Method, class에서 사용 가능
 * */
@Component
@Target( {ElementType.METHOD, ElementType.TYPE } )
@Retention( RetentionPolicy.RUNTIME )
public @interface Bridge {
		
		// 로그를 남길 지 여부
		boolean isLogging() default true;
}
