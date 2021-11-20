package com.jwland.config;

import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring()
			.mvcMatchers("/node_modules/**")
			.requestMatchers(PathRequest.toStaticResources().atCommonLocations())
			
			;
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// 요청 권한 관련
		http.authorizeRequests()
				.mvcMatchers("/", "/login", "/menu", "/join")
					.permitAll()
				.anyRequest().authenticated();

		// 로그인
		http.formLogin()
				.loginPage("/login")
				.usernameParameter("name")
				.passwordParameter("birth")
				.permitAll();
		// 로그아웃
		http.logout()
				.logoutSuccessUrl("/");
	}
}


















