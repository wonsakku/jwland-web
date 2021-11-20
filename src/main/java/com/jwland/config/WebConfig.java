package com.jwland.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.jwland.web.common.AccessInterceptor;
import com.jwland.web.constant.UrlPathContant;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Configuration
public class WebConfig implements WebMvcConfigurer {

	private final AccessInterceptor accessInterceptor;
	
	
	
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		
		registry.addInterceptor(accessInterceptor)
			.excludePathPatterns(UrlPathContant.staticResourcePath())
			.addPathPatterns(UrlPathContant.anyoneAccessablePath())
			.addPathPatterns(UrlPathContant.onlyAdminAccessablePath())
			.addPathPatterns(UrlPathContant.studentAccessablePath())
			;
	}
	

	
	
}























