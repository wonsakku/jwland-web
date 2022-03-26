package com.jwland.web.admin.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.jwland.domain.classes.dto.ClassAccountMapDto;
import com.jwland.domain.classes.dto.ClassAttendanceEnrollDto;
import com.jwland.domain.classes.dto.ClassDetailDto;
import com.jwland.domain.classes.dto.ClassListDto;
import com.jwland.domain.classes.dto.CreateClassDto;
import com.jwland.domain.classes.dto.EnrolledAccountsDto;
import com.jwland.domain.classes.dto.PersonalClassAttendanceDto;
import com.jwland.web.admin.service.AdminClassService;
import com.jwland.web.constant.VariableConstant;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
@RestController
@RequestMapping("/admin/class")
public class AdminClassController {

	private final AdminClassService classService;
	
	@GetMapping("/enroll-page")
	public ModelAndView classEnrollPage() {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("admin/class/class-enroll");
		return mav;
	}
	

	@GetMapping("/types")
	public ResponseEntity<List<Map>> getClassTypes(){
		List<Map> classTypes = classService.getClassTypes();
		return ResponseEntity.status(HttpStatus.OK).body(classTypes);
	}
	
	
	@PostMapping("/enroll")
	public ResponseEntity<String> enrollClass(@RequestBody @Validated CreateClassDto createClassDto, 
									HttpServletRequest request,
									RedirectAttributes rttr) {
		
		classService.enrollClass(createClassDto, request);
		return ResponseEntity.status(HttpStatus.OK).body(VariableConstant.CLASS_ENROLL_SUCCESS);
	}
	
	@GetMapping("/detail-manage-page")
	public ModelAndView classDetailManagePage() {
		return new ModelAndView("admin/class/class-detail-manage");
	}
	
	@GetMapping("/classes")
	public ResponseEntity<List<ClassListDto>> getClassList(@RequestParam(value = "open", required = false, defaultValue = "") String open){
		List<ClassListDto> classList = classService.getClassList(open);
		return ResponseEntity.status(HttpStatus.OK).body(classList);
	}
	
	
	@GetMapping("/classes/{classSequenceNo}")
	public ResponseEntity<ClassDetailDto> getClassDetail(@PathVariable int classSequenceNo){
		
		log.info("classSequenceNo={}", classSequenceNo);
		
		ClassDetailDto classDetailDto = classService.getClassDetail(classSequenceNo);
		return ResponseEntity.status(HttpStatus.OK).body(classDetailDto);
	}
	
	@PostMapping("/classes/{classSequenceNo}/update")
	public ResponseEntity updateClass(@PathVariable int classSequenceNo, @RequestBody ClassDetailDto classDetailDto) {
		
		classDetailDto.setClassSequenceNo(classSequenceNo);
		log.info("classDetailDto={}", classDetailDto);
		classService.updateClass(classDetailDto);
		return ResponseEntity.status(HttpStatus.OK).body(VariableConstant.CLASS_UPDATE_SUCCESS);
	}
	
	
	@GetMapping("/classes/{classSequenceNo}/add-student")
	public ModelAndView addStudentPage(@PathVariable int classSequenceNo, 
									   @RequestParam(value = "className", required = true) String className) {
		
		ModelAndView mav = new ModelAndView("admin/class/class-add-student");
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
	public ResponseEntity<String> enrollStudentToClass(@RequestBody @Validated ClassAccountMapDto classAccountMapDto) {
		int updateCnt = classService.enrollStudentToClass(classAccountMapDto);
		return ResponseEntity.status(HttpStatus.OK).body(updateCnt + VariableConstant.ACCOUNT_ENROLL_CLASS_SUCCESS_SUFFIX);
	}
	
	
	@GetMapping("/classes/{classSequenceNo}/check-attendance")
	public ModelAndView checkAttendancePage(@PathVariable int classSequenceNo, 
			   @RequestParam(value = "className", required = true) String className) {
		ModelAndView mav = new ModelAndView("admin/class/attendance-check");
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
	public ResponseEntity<String> classAttendanceEnroll
			(@RequestBody @Validated ClassAttendanceEnrollDto classAttendanceEnrollDto, 
			HttpServletRequest request) {
//		int classSequenceNo = classAttendanceEnrollDto.getClassSequenceNo();
		classService.classAttendanceEnroll(classAttendanceEnrollDto, request);
//		rttr.addFlashAttribute(VariableConstant.MESSAGE, "출석 등록이 완료되었습니다.");
		return ResponseEntity.status(HttpStatus.OK).body(VariableConstant.ATTENDANCE_ENROLL_SUCCESS);
	}
	
	
	
	@GetMapping("/classes/{classSequenceNo}/attendance-info")
	public ResponseEntity<List<PersonalClassAttendanceDto>> findAttendanceInfoByDate(@RequestParam(value = "classDate") String classDate,
			@PathVariable int classSequenceNo) {
		List<PersonalClassAttendanceDto> list = classService.findAttendanceInfoByDate(classDate, classSequenceNo);
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}

	@GetMapping("/classes/{classSequenceNo}/class-manage-page")
	public ModelAndView classManagePage(@PathVariable String classSequenceNo) {
		
		ModelAndView mav = new ModelAndView("admin/class/class-manage-page");
		mav.addObject("classSequenceNo", classSequenceNo);
		return mav;
	}
	
	
	
}






























