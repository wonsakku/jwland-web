package com.jwland.web.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.flash;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.transaction.annotation.Transactional;

import com.jwland.web.service.AccountService;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class AccountControllerTest {

	@Autowired MockMvc mockMvc;
	@Autowired AccountService accountService;
//	@Autowired private MockHttpServletRequest request;
	
	@Test
	@DisplayName("로그인 페이지 이동")
	void formLoginPage() throws Exception{
		mockMvc.perform(get("/login"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(view().name("account/sign-in"))
			.andExpect(model().attributeExists("formLoginDto"))
			;
	}
	
	@Test
	@DisplayName("로그인 성공")
	void formLoginSuccess() throws Exception{

		MvcResult result = mockMvc.perform(
							post("/login")
							.param("name", "나미")
							.param("birth", "0703")
						)
						.andExpect(status().is3xxRedirection())
						.andExpect(view().name("redirect:/"))
						.andDo(print())
						.andExpect(request().sessionAttribute("accountSequenceNo", 3L))
						.andExpect(request().sessionAttribute("approved", "N"))
						.andExpect(request().sessionAttribute("role", "student"))
						.andExpect(request().sessionAttribute("nickName", "도둑 고양이"))
						.andReturn()
						;
//		assertThat(result.getRequest().getSession().getAttribute("accountSequenceNo")).isEqualTo(3L);
//		assertThat(result.getRequest().getSession().getAttribute("role")).isEqualTo("student");
//		assertThat(result.getRequest().getSession().getAttribute("approved")).isEqualTo("N");
	}

	@Test
	@DisplayName("로그인 실패 - 일치하는 정보 없을 경우 ")
	void formLoginFail_01() throws Exception{
		mockMvc.perform(
				post("/login")
				.param("name", "조로")
				.param("birth", "0703")
				)
				.andExpect(status().is3xxRedirection())
				.andExpect(view().name("redirect:/login"))
				.andExpect(flash().attributeExists("error"))
				.andExpect(flash().attribute("error", "일치하는 계정 정보가 없습니다."))
				;
	}
	
	@Test
	@DisplayName("로그아웃")
	void lotgout_Success() throws Exception {
		
		mockMvc.perform(
				post("/logout")
				.sessionAttr("accountSequenceNo", 3L)
				.sessionAttr("birth", "0703")
				.sessionAttr("nickName", "도둑 고양이")
				.sessionAttr("approved", "N")
				)
			.andDo(print())
			.andExpect(view().name("redirect:/"))
			.andExpect(status().is3xxRedirection())
			.andExpect(request().sessionAttributeDoesNotExist("accountSequenceNo", "approved", "role", "nickName"))
			;
	}

	@Test
	@DisplayName("로그아웃 실패 - 잘못된 접근")
	void logout_Fail_01() throws Exception{
		mockMvc.perform(post("/logout"))
			.andDo(print())
			.andExpect(view().name("redirect:/"))
			.andExpect(status().is3xxRedirection())
			.andExpect(flash().attributeExists("error"))
			.andExpect(flash().attribute("error", "잘못된 접근 방식입니다."))
			;
	}
	
	@Test
	@DisplayName("회원가입 페이지 이동")
	void join() throws Exception {
		mockMvc.perform(get("/join"))
			.andDo(print())
			.andExpect(view().name("account/join"))
			.andExpect(status().isOk())
			.andExpect(model().attributeExists("joinAccountDto"))
			;
	}
	
	
	@Test
	@DisplayName("회원가입")
	void join_Success() throws Exception{
		mockMvc.perform(
				post("/join")
				.param("name", "비비")
				.param("birth", "0202")
				.param("nickName", "미스 웬즈데이")
				)
			.andExpect(status().is3xxRedirection())
			.andExpect(view().name("redirect:/login"))
			;
	}
	
	
	@Test
	@DisplayName("회원가입 - 입력값 오류")
	void join_Fail_01() throws Exception{
		MvcResult result = mockMvc.perform(
				post("/join")
				.param("name", "비비")
				.param("birth", "2")
				.param("nickName", "미스 웬즈데이")
//				.with(csrf())
				)
		.andExpect(status().isBadRequest())
		.andExpect(flash().attributeExists("error"))
		.andExpect(view().name("redirect:/join"))
		.andReturn()
		;
		
//		System.out.println(result.getFlashMap().get("error").toString());
	}
	
}

















