package com.jwland.config;

//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter{
//
//	@Override
//	public void configure(WebSecurity web) throws Exception {
//		web.ignoring()
//			.mvcMatchers("/node_modules/**")
//			.requestMatchers(PathRequest.toStaticResources().atCommonLocations())
//			
//			;
//	}
//	
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		// 요청 권한 관련
//		http.authorizeRequests()
//				.mvcMatchers("/", "/login", "/menu", "/join")
//					.permitAll()
//				.anyRequest().authenticated();
//
//		// 로그인
//		http.formLogin()
//				.loginPage("/login")
//				.usernameParameter("name")
//				.passwordParameter("birth")
//				.permitAll();
//		// 로그아웃
//		http.logout()
//				.logoutSuccessUrl("/");
//	}
//}


















