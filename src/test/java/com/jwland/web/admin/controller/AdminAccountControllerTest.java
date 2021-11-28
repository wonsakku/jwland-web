package com.jwland.web.admin.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.Arrays;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jwland.web.constant.VariableConstant;

@Transactional
@SpringBootTest
@AutoConfigureMockMvc
class AdminAccountControllerTest {

	@Autowired MockMvc mockMvc;
	@Autowired ObjectMapper objectMapper;
	
	@Test
	@DisplayName("학생관리 - 학생 데이터 가져오기 테스트")
	void get_Account_Management_List() throws Exception {
		mockMvc.perform(get("/admin/accounts"))
			.andDo(print())
			.andExpect(status().isOk())
			
			;
	}

	@Test
	@DisplayName("학생관리 - 학생 데이터 가져오기 테스트 - 이름 입력")
	void get_Account_Management_List_with_Name() throws Exception {
		mockMvc.perform(
				get("/admin/accounts")
				.param("name", "밀리제")
			)
		.andDo(print())
		.andExpect(status().isOk())
		;
	}
	
	@Test
	@DisplayName("학생관리 - 학생 데이터 가져오기 테스트 - 상태 입력")
	void get_Account_Management_List_with_Approved() throws Exception {
		mockMvc.perform(
				get("/admin/accounts")
				.param("approved", "Y")
				)
		.andDo(print())
		.andExpect(status().isOk())
		;
	}
	
	
	@Test
	@DisplayName("학생관리 - 학생 데이터 가져오기 테스트 - 이름 & 상태 입력")
	void get_Account_Management_List_with_Name_Approved() throws Exception {
		mockMvc.perform(
				get("/admin/accounts")
				.param("name", "밀리제")
				.param("approved", "N")
				)
		.andDo(print())
		.andExpect(status().isOk())
		;
	}

	
	@Test
	@DisplayName("학생관리 - 사용 승인")
	void approve_Using() throws Exception{
		MvcResult result = mockMvc.perform(
					put("/admin/accounts/use-approve")
					.contentType(MediaType.APPLICATION_JSON)
					.content(objectMapper.writeValueAsString(Arrays.asList("2", "3", "4")))
				)
			.andDo(print())
			.andExpect(status().isOk())
			.andReturn()
			;
		
		assertThat(result.getResponse().getContentAsString()).isEqualTo(VariableConstant.USING_APPROVE_MESSAGE);
	}
	

}



