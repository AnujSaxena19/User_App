package com.User.Controller;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.GenericFilterBean;

public class CustomFilter extends GenericFilterBean{

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest rs=(HttpServletRequest)request;
		Enumeration<String> headerName=rs.getHeaderNames();
		boolean flag=false;
		
		while(headerName.hasMoreElements()) {
			String key=(String)headerName.nextElement();
			
			if(key.equals("fname")||key.equals("lname")) {
				flag=true;
			}
		}
		if(flag) {
			chain.doFilter(request, response);
		}
		else {
			((HttpServletResponse)response).sendError(HttpServletResponse.SC_FORBIDDEN,"Keys not found in header!! Please put keys in header");
			
		}
		
	}

}
