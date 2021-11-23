package com.jwland.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

import com.jwland.domain.classes.ClassAccountMapDto;
import com.jwland.domain.classes.ClassAttendanceEnrollDto;
import com.jwland.domain.classes.ClassDetailDto;
import com.jwland.domain.classes.CreateClassDto;
import com.jwland.domain.classes.EnrolledAccountsDto;
import com.jwland.domain.classes.PersonalClassAttendanceDto;
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
	
	@GetMapping("/classes/{classSequenceNo}/accounts")
	public ResponseEntity<List<Integer>> getEnrolledAccounts(@PathVariable int classSequenceNo){
		List<Integer> classSequenceNoList = classService.getEnrolledAccounts(classSequenceNo);
		return ResponseEntity.status(HttpStatus.OK).body(classSequenceNoList);
	}
	
	
	@PostMapping("/classes/student/enroll")
	public ModelAndView enrollStudentToClass(@ModelAttribute ClassAccountMapDto classAccountMapDto, RedirectAttributes rttr) {
		classService.enrollStudentToClass(classAccountMapDto);
		rttr.addFlashAttribute(VariableConstant.MESSAGE, "등록되었습니다.");
		return new ModelAndView("redirect:/class/detail-manage-page");
	}
	
	
	@GetMapping("/classes/{classSequenceNo}/check-attendance")
	public ModelAndView checkAttendancePage(@PathVariable int classSequenceNo, 
			   @RequestParam(value = "className", required = true) String className) {
		ModelAndView mav = new ModelAndView("class/attendance-check");
		mav.addObject("className", className);
		mav.addObject("classSequenceNo", classSequenceNo);
		return mav;
	}
	
	@GetMapping("/classes/{classSequenceNo}/account-infos")
	public ResponseEntity<List<EnrolledAccountsDto>> getEnrolledAccountInfos(@PathVariable int classSequenceNo){
		List<EnrolledAccountsDto> accountsInfos = classService.getEnrolledAccountInfos(classSequenceNo);
		return ResponseEntity.status(HttpStatus.OK).body(accountsInfos);
	}
	
	@GetMapping("/classes/{classSequenceNo}/date")
	public ResponseEntity<List<String>> getClassDate(@PathVariable int classSequenceNo){
		List<String> classDateList = classService.getClassDate(classSequenceNo);
		return ResponseEntity.status(HttpStatus.OK).body(classDateList);
	}
	
	@PostMapping("/classes/attendance/enroll")
	public ModelAndView classAttendanceEnroll
			(@ModelAttribute @Validated ClassAttendanceEnrollDto classAttendanceEnrollDto, 
			HttpServletRequest request, RedirectAttributes rttr){
		int classSequenceNo = classAttendanceEnrollDto.getClassSequenceNo();
		String className = classAttendanceEnrollDto.getClassName();
		classService.classAttendanceEnroll(classAttendanceEnrollDto, request);
		rttr.addFlashAttribute(VariableConstant.MESSAGE, "출석 등록이 완료되었습니다.");
		return new ModelAndView("redirect:/class/classes/" + classSequenceNo + "/check-attendance?className=" + className);
	}
	
	@GetMapping("/classes/{classSequenceNo}/attendance-info")
	public ResponseEntity<List<PersonalClassAttendanceDto>> findAttendanceInfoByDate(@RequestParam(value = "classDate") String classDate,
			@PathVariable int classSequenceNo) {
		List<PersonalClassAttendanceDto> list = classService.findAttendanceInfoByDate(classDate, classSequenceNo);
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
}


















