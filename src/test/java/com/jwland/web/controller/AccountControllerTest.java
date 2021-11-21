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
import com.jwland.web.constant.ExceptionMessages;
import com.jwland.web.constant.UrlPathConstant;
import com.jwland.web.constant.VariableConstant;
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
	
	@Test
	@DisplayName("로그인 페이지 이동")
	void formLoginPage() throws Exception{
		mockMvc.perform(get("/login"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(view().name("account/sign-in"))
			.andExpect(model().attributeExists(VariableConstant.FORM_LOGIN_DTO))
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
						.andExpect(view().name(UrlPathConstant.REDIRECT_ROOT_PAGE))
						.andDo(print())
//						.andExpect(request().se)
						.andReturn()
						;
		//when
		MockHttpServletRequest request = result.getRequest();
		HttpSession session = request.getSession();
		
		// then 
		assertThat(session.getAttribute(VariableConstant.LOGIN_ATTRIBUTE_NAME)).isNotNull();
		assertThat(session.getAttribute(VariableConstant.LOGIN_ATTRIBUTE_NAME)).isInstanceOf(LoginSuccessDto.class);
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
//				.andExpect(view().name(UrlPathContant.REDIRECT_LOGIN_PAGE))
				.andExpect(view().name(UrlPathConstant.REDIRECT_LOGIN_PAGE))
				.andExpect(flash().attributeExists(VariableConstant.ERROR))
//				.andExpect(flash().attribute(VariableConstant.ERROR, "일치하는 계정 정보가 없습니다."))
				.andExpect(flash().attribute(VariableConstant.ERROR, ExceptionMessages.NO_ACCOUNT_ERROR.getMessage()))
				;
	}

	
	@Test
	@DisplayName("로그인 실패 - 입력값 오류")
	void formLogin_Fail_02() throws Exception{
		
		mockMvc.perform(
				post("/login")
				.param("name", "나미")
				.param("birth", "07031")
				)
				.andExpect(flash().attributeExists(VariableConstant.ERROR))
				.andExpect(status().is3xxRedirection())
				.andExpect(view().name(UrlPathConstant.REDIRECT_LOGIN_PAGE))
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
				.approved(DEFAULT_APPROVED)
				.role(DEFAULT_ROLE)
				.accountSequenceNo(3L)
				.build();
		
		// when & then
		mockMvc.perform(
				post("/logout")
				.sessionAttr(VariableConstant.LOGIN_ATTRIBUTE_NAME, login)
				)
			.andDo(print())
			.andExpect(view().name(UrlPathConstant.REDIRECT_ROOT_PAGE))
			.andExpect(status().is3xxRedirection())
			.andExpect(request().sessionAttributeDoesNotExist(VariableConstant.LOGIN_ATTRIBUTE_NAME))
			;
	}

	@Test
	@DisplayName("로그아웃 실패 - 잘못된 접근")
	void logout_Fail_01() throws Exception{
		mockMvc.perform(post("/logout"))
			.andDo(print())
//			.andExpect(view().name(UrlPathContant.REDIRECT_ROOT_PAGE))
			.andExpect(view().name(UrlPathConstant.REDIRECT_ROOT_PAGE))
			.andExpect(status().is3xxRedirection())
			.andExpect(flash().attributeExists(VariableConstant.ERROR))
			.andExpect(flash().attribute(VariableConstant.ERROR, ExceptionMessages.WRONG_ACCESS_ERROR.getMessage()))
			;
	}
	
	@Test
	@DisplayName("회원가입 페이지 이동")
	void join() throws Exception {
		mockMvc.perform(get("/join"))
			.andDo(print())
			.andExpect(view().name("account/join"))
			.andExpect(status().isOk())
			.andExpect(model().attributeExists(VariableConstant.JOIN_ACCOUNT_DTO))
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
			.andExpect(flash().attributeExists(VariableConstant.MESSAGE))
			.andExpect(flash().attribute(VariableConstant.MESSAGE, nickName + VariableConstant.JOIN_SUCCESS_MESSAGE_SURFFIX))
//			.andExpect(view().name(UrlPathContant.REDIRECT_LOGIN_PAGE))
			.andExpect(view().name(UrlPathConstant.REDIRECT_LOGIN_PAGE))
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
		.andExpect(flash().attributeExists(VariableConstant.ERROR))
		.andExpect(view().name(UrlPathConstant.REDIRECT_JOIN_PAGE))
//		.andReturn()
		;
	}

	
}

















