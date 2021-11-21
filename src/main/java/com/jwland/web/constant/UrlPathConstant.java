package com.jwland.web.constant;

import java.util.Arrays;
import java.util.List;

public interface UrlPathConstant {

	public static final String REDIRECT_PREFIX = "redirect:";
	public static final String REDIRECT_LOGIN_PAGE = "redirect:/login";
	public static final String REDIRECT_JOIN_PAGE = "redirect:/join";
	public static final String REDIRECT_ROOT_PAGE = "redirect:/";
	
	
	public static List<String> staticResourcePath(){
		return Arrays.asList("/css/**", "/js/**", "/images/**", "/node_modules/**");
	}
	
	public static List<String> anyoneAccessablePath(){
		return Arrays.asList("/", "/login", "/logout", "/join");
	}
	
	
	public static List<String> studentAccessablePath(){
		return Arrays.asList("/clinic/**", "/exam-check/**", "/errata/**", "/board/**", "/notice/**");
	}
	
	
	public static List<String> onlyAdminAccessablePath(){
		return Arrays.asList("/attendance/**", "/clinic-attendance/**", "/class/**");
	}

	
}
