package com.jwland.web.controller;

import java.util.List;
import java.util.Map;

import javax.management.RuntimeErrorException;
import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.jwland.domain.clinic.ClinicAccountMapDto;
import com.jwland.domain.clinic.EnrollClinicDto;
import com.jwland.web.constant.ExceptionMessages;
import com.jwland.web.constant.VariableConstant;
import com.jwland.web.service.ClinicService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
public class ClinicController {

	private final ClinicService clinicService;
	
	@GetMapping("/clinic/page")
	public ModelAndView clinicPage() {
		return new ModelAndView("clinic/clinic-page");
	}
	
	@GetMapping("/clinic")
	public ResponseEntity<List<Map>> loadClinicData(@RequestParam(value = "date", required = true) String date,
			@RequestParam(value = "accountSequenceNo", required = true) String accountSequenceNo){
		List<Map> clinicList = clinicService.loadClinicData(date, accountSequenceNo);
		log.info("clinic-data```{}", clinicList);
		return ResponseEntity.status(HttpStatus.OK).body(clinicList);
	}
	
	@GetMapping("/clinic/list")
	public ResponseEntity<List<Map>> loadClinicList(@RequestParam(value = "startDate", required = true) String startDate,
			@RequestParam(value = "endDate", required = true) String endDate){
		List<Map> clinicList = clinicService.loadClinicList(startDate, endDate);
		log.info("clinic-data```{}", clinicList);
		return ResponseEntity.status(HttpStatus.OK).body(clinicList);
	}
	
	@GetMapping("/clinic/types")
	public ResponseEntity<List<Map>> getClinicTypes(){
		List<Map> clinicTypes = clinicService.getClinicTypes();
		return ResponseEntity.status(HttpStatus.OK).body(clinicTypes);
	}

	@GetMapping("/clinic/class-types")
	public ResponseEntity<List<Map>> getClassTypes(@RequestParam(name = "accountSequenceNo") String accountSequenceNo){
		List<Map> classTypes = clinicService.getClassTypes(accountSequenceNo);
		return ResponseEntity.status(HttpStatus.OK).body(classTypes);
	}
	
	@PostMapping("/clinic/enroll")
	public ResponseEntity<String> enrollClinic(@RequestBody @Valid EnrollClinicDto enrollClinicDto){
		int enrollClinicCnt = clinicService.enrollClinic(enrollClinicDto);
		if(enrollClinicCnt < 1) {
			throw new RuntimeException(ExceptionMessages.CLINIC_ENROLL_ERROR.getMessage());
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(VariableConstant.CLINIC_ENROLL_SUCCESS);
	}

	@PostMapping("/clinic/apply")
	public ResponseEntity<String> applyClinic(@RequestBody @Valid ClinicAccountMapDto clinicAccountMapDto){
		int applyClinicCnt = clinicService.applyClinic(clinicAccountMapDto);
		
		if(applyClinicCnt < 1) {
			throw new RuntimeException(ExceptionMessages.CLINIC_APPLY_ERROR.getMessage());
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(VariableConstant.CLINIC_APPLY_SUCCESS);
	}

	@DeleteMapping("/clinic/cancel")
	public ResponseEntity<String> cancelClinic(@RequestBody @Valid ClinicAccountMapDto clinicAccountMapDto){
		int applyClinicCnt = clinicService.cancelClinic(clinicAccountMapDto);
		
		if(applyClinicCnt < 1) {
			throw new RuntimeException(ExceptionMessages.CLINIC_CANCEL_ERROR.getMessage());
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(VariableConstant.CLINIC_CANCEL_SUCCESS);
	}
}























