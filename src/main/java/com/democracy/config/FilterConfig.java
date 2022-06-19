package com.democracy.config;

import com.democracy.common.filter.LogFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 필터 등록
 *
 * @author ted
 * @version 2022.06.18 1.0 ted :
 * */
@Configuration
public class FilterConfig {

		@Bean
		public FilterRegistrationBean<LogFilter> filterRegistrationBean() {
				
				FilterRegistrationBean<LogFilter> registrationBean = new FilterRegistrationBean<>();
				registrationBean.setFilter( new LogFilter() );
				registrationBean.addUrlPatterns( "/*" );
				registrationBean.setOrder( 1 );
				registrationBean.setName( "LogFilter" );
				return registrationBean;
		}
}

