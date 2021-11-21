package com.jwland.web.constant;

import java.util.Arrays;
import java.util.List;

public interface UrlPathContant {

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
		return Arrays.asList("/attendance/**", "/clinic-attendance/**");
	}
	
	
}
