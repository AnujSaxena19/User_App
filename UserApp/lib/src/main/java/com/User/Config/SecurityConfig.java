package com.User.Config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.User.Controller.CustomFilter;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.addFilterAfter(new CustomFilter(), BasicAuthenticationFilter.class);
		
		http.csrf().disable();
		
	}
	
	
	
}
