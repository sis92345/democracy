package com.democracy.common.aspect;

import com.democracy.common.util.MDCUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

@Aspect
public class BridgeAspect {
		
		private static final Logger bridgeLog = LoggerFactory.getLogger( "BRIDGE_LOG" );
		private static final Logger log = LoggerFactory.getLogger( "log" );
		
		@Around( "@annotation(com.democracy.common.annotation.Bridge)" )
		public Object bridgeLogging( ProceedingJoinPoint joinPoint ) throws Throwable {
				
				MethodSignature signature = (MethodSignature) joinPoint.getSignature();
				String methodName = signature.getMethod().getName();
				
				Object[] signatureArgs = joinPoint.getArgs();
				StringBuilder sb = new StringBuilder();
				
				for (Object signatureArg: signatureArgs ) {
						String log = signatureArg.toString();
						sb.append( log );
				}
				
				Object result = null;
				try {
						result = joinPoint.proceed();
				}
				finally {
						
						MDCUtils.put( "parameter" , sb.toString() );
						String requestUUID = MDCUtils.get( "requestUUID" );
						
						sb.append( " / " ).append( requestUUID );
						
						log.info( sb.toString() );
						bridgeLog.info( "" );
				}
				
				return result;
		}
		
}
