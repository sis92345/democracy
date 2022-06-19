package com.democracy.common.filter;

import com.democracy.common.util.MDCUtils;
import com.democracy.common.util.UUidGenerator;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class LogFilter implements Filter {
		
		@Override
		public void doFilter( ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain ) throws IOException, ServletException {
		
				MDCUtils.put( "requestUUID" , UUidGenerator.Generate() );
		}
		
		
		@Override
		public void destroy() {
		
				MDCUtils.clear();
		}
}
