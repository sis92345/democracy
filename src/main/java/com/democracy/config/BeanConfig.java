package com.democracy.config;

import com.democracy.common.aspect.BridgeAspect;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class BeanConfig {
		
		@Bean
		public BridgeAspect bridgeAspect() {
				return new BridgeAspect();
		}
}
