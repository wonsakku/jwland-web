package com.jwland.web.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.flash;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.request;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import javax.servlet.http.HttpSession;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.transaction.annotation.Transactional;

import com.jwland.domain.account.AccountVO;
import com.jwland.domain.account.LoginSuccessDto;
import com.jwland.web.constant.AccountConstant;
import com.jwland.web.constant.SessionConstant;
import com.jwland.web.mapper.AccountMapper;
import com.jwland.web.service.AccountService;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class AccountControllerTest {

	@Autowired MockMvc mockMvc;
	@Autowired AccountService accountService;
	@Autowired AccountMapper accountMapper;
//	@Autowired private MockHttpServletRequest request;
	
	private final String DEFAULT_ROLE = "ROLE_STUDENT";
	private final String DEFAULT_APPROVED = "N";
	private final String DEFAULT_JOIN_SUCCESS_MSG_SUFFIX = "님의 가입이 완료되었습니다.";
	
	@Test
	@DisplayName("로그인 페이지 이동")
	void formLoginPage() throws Exception{
		mockMvc.perform(get("/login"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(view().name("account/sign-in"))
			.andExpect(model().attributeExists(AccountConstant.FORM_LOGIN_DTO))
			;
	}
	
	@Test
	@DisplayName("로그인 성공")
	void formLoginSuccess() throws Exception{

		// given
		MvcResult result = mockMvc.perform(
							post("/login")
							.param("name", "나미")
							.param("birth", "0703")
						)
						.andExpect(status().is3xxRedirection())
						.andExpect(view().name("redirect:/"))
						.andDo(print())
//						.andExpect(request().se)
						.andReturn()
						;
		//when
		MockHttpServletRequest request = result.getRequest();
		HttpSession session = request.getSession();
		
		// then 
		assertThat(session.getAttribute(SessionConstant.LOGIN_ATTRIBUTE_NAME)).isNotNull();
		assertThat(session.getAttribute(SessionConstant.LOGIN_ATTRIBUTE_NAME)).isInstanceOf(LoginSuccessDto.class);
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
	@DisplayName("로그인 실패 - 입력값 오류")
	void formLogin_Fail_02() throws Exception{
		
		// given
		MvcResult result = mockMvc.perform(
				post("/login")
				.param("name", "나미")
				.param("birth", "07031")
				)
				.andExpect(flash().attributeExists("error"))
				.andExpect(status().is3xxRedirection())
				.andExpect(view().name("redirect:/login"))
				.andDo(print())
				.andReturn()
				;
	}
	
	
	
	@Test
	@DisplayName("로그아웃")
	void lotgout_Success() throws Exception {
		
		// given
		LoginSuccessDto login = LoginSuccessDto.builder()
				.nickName("도둑 고양이")
				.approved("N")
				.role("ROLE_STUDENT")
				.accountSequenceNo(3L)
				.build();
		
		// when & then
		mockMvc.perform(
				post("/logout")
				.sessionAttr(SessionConstant.LOGIN_ATTRIBUTE_NAME, login)
				)
			.andDo(print())
			.andExpect(view().name("redirect:/"))
			.andExpect(status().is3xxRedirection())
			.andExpect(request().sessionAttributeDoesNotExist(SessionConstant.LOGIN_ATTRIBUTE_NAME))
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
			.andExpect(model().attributeExists(AccountConstant.JOIN_ACCOUNT_DTO))
			;
	}
	
	
	
	@Test
	@DisplayName("회원가입")
	void join_Success() throws Exception{

		String name = "비비";
		String birth = "0202";
		String nickName = "미스 웬즈데이";
		
		mockMvc.perform(
				post("/join")
				.param("name", name)
				.param("birth", birth)
				.param("nickName", nickName)
				)
			.andDo(print())
			.andExpect(status().is3xxRedirection())
			.andExpect(flash().attributeExists("msg"))
			.andExpect(flash().attribute("msg", nickName + DEFAULT_JOIN_SUCCESS_MSG_SUFFIX))
			.andExpect(view().name("redirect:/login"))
			; 
		
		AccountVO newAccount = accountMapper.findByName(name);
		assertThat(newAccount).isNotNull();
		assertThat(newAccount.getAccountSequenceNo()).isNotNull();
		assertThat(newAccount.getName()).isEqualTo(name);
		assertThat(newAccount.getNickName()).isEqualTo(nickName);
		assertThat(newAccount.getBirth()).isEqualTo(birth);
		assertThat(newAccount.getApproved()).isEqualTo(DEFAULT_APPROVED);
		assertThat(newAccount.getRole()).isEqualTo(DEFAULT_ROLE);
	}
	
	
	@Test
	@DisplayName("회원가입 - 입력값 오류")
	void join_Fail_01() throws Exception{
		mockMvc.perform(
				post("/join")
				.param("name", "비비")
				.param("birth", "2")
				.param("nickName", "미스 웬즈데이")
				)
		.andExpect(status().is3xxRedirection())
		.andExpect(flash().attributeExists("error"))
		.andExpect(view().name("redirect:/join"))
//		.andReturn()
		;
	}

	
}

















