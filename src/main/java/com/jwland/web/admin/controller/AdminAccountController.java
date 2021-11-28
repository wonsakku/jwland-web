package com.jwland.web.admin.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.jwland.domain.account.dto.AccountManagementDto;
import com.jwland.web.admin.service.AdminAccountService;
import com.jwland.web.constant.VariableConstant;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/admin/accounts")
public class AdminAccountController {

	private final AdminAccountService adminAccountService;
	
	@GetMapping("/account-manage-page")
	public ModelAndView accountManagePage() {
		return new ModelAndView("admin/account-manage-page");
	}
	
	@GetMapping
	public List<AccountManagementDto> getAccountManagementList(
			@RequestParam(value = "name", required = false, defaultValue = "") String name,
			@RequestParam(value = "approved", required = false, defaultValue = "") String approved){
		return adminAccountService.getAccountManagementList(name, approved);
	}
	
	@PutMapping("/use-approve")
	public ResponseEntity<String> updateApproveStatus(@RequestBody List<Integer> accountSequenceList){
		adminAccountService.updateApproveStatus(accountSequenceList);
		return ResponseEntity.status(HttpStatus.OK).body(VariableConstant.USING_APPROVE_MESSAGE);
	}
}















