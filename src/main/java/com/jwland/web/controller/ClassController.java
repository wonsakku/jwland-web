package com.jwland.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jwland.domain.classes.ClassDetailDto;
import com.jwland.domain.classes.CreateClassDto;
import com.jwland.web.constant.VariableConstant;
import com.jwland.web.service.ClassService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/class")
public class ClassController {

	private final ClassService classService;
	
	@GetMapping("/enroll-page")
	public ModelAndView classEnrollPage() {
		ModelAndView mav = new ModelAndView();
		mav.addObject("createClassDto", new CreateClassDto());
		mav.setViewName("class/class-enroll");
		return mav;
	}
	
	@GetMapping("/manage-page")
	public ModelAndView classManagePage() {
		return new ModelAndView("class/class-manage");
	}
	
	
	@PostMapping("/enroll")
	public ModelAndView enrollClass(@ModelAttribute(value = "createClassDto") 
									@Validated CreateClassDto createClassDto, 
									HttpServletRequest request,
									RedirectAttributes rttr) {
		
		classService.enrollClass(createClassDto, request);
		rttr.addFlashAttribute(VariableConstant.MESSAGE, "강의가 등록되었습니다.");
		
		return new ModelAndView("redirect:/class/manage-page");
	}
	
	@GetMapping("/detail-manage-page")
	public ModelAndView classDetailManagePage() {
		return new ModelAndView("class/class-detail-manage");
	}
	
	@GetMapping("/classes")
	public List<ClassDetailDto> getClassDetails(@RequestParam(value = "open", required = false, defaultValue = "OPEN") String open){
		return classService.getClassDetails(open);
	}
	
	
	@GetMapping("/classes/{classSequenceNo}/add-student")
	public ModelAndView addStudentPage(@PathVariable int classSequenceNo, 
									   @RequestParam(value = "className", required = true) String className) {
		
		ModelAndView mav = new ModelAndView("class/class-add-student");
		mav.addObject("classSequenceNo", classSequenceNo);
		mav.addObject("className", className);
		return mav;
	}
	
	
}


















