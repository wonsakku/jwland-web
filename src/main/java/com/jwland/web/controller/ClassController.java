package com.jwland.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jwland.domain.classes.CreateClassDto;
import com.jwland.web.constant.VariableConstant;
import com.jwland.web.service.ClassService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@RestController
public class ClassController {

	private final ClassService classService;
	
	@GetMapping("/class/enroll-page")
	public ModelAndView classEnrollPage() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("createClassDto", new CreateClassDto());
		mav.setViewName("class/class-enroll");
		return mav;
	}
	
	@GetMapping("/class/manage-page")
	public ModelAndView classManagePage() {
		return new ModelAndView("class/class-manage");
	}
	
	
	@PostMapping("/class/enroll")
	public ModelAndView enrollClass(@ModelAttribute(value = "createClassDto") 
									@Validated CreateClassDto createClassDto, 
									HttpServletRequest request,
									RedirectAttributes rttr) {
		
		classService.enrollClass(createClassDto, request);
		rttr.addFlashAttribute(VariableConstant.MESSAGE, "강의가 등록되었습니다.");
		
		return new ModelAndView("redirect:/class/manage-page");
	}
	
	@GetMapping("/class/detail-manage-page")
	public ModelAndView classDetailManagePage() {
		return new ModelAndView("class/class-detail-manage");
	}
	
	
}


















