package com.jwland.web.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.flash;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

import com.jwland.domain.account.dto.LoginSuccessDto;
import com.jwland.domain.classes.ClassVO;
import com.jwland.web.admin.mapper.AdminClassMapper;
import com.jwland.web.admin.service.AdminClassService;
import com.jwland.web.constant.ExceptionMessages;
import com.jwland.web.constant.UrlPathConstant;
import com.jwland.web.constant.VariableConstant;
import com.jwland.web.exception.AuthenticationException;
import com.jwland.web.exception.AuthorizeException;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class ClassControllerTest {


//	MockMvc mockMvc;
//	@Autowired WebApplicationContext ctx;
	@Autowired MockMvc mockMvc;
	
	@Autowired AdminClassService classService;
	@Autowired AdminClassMapper classMapper;
	
	
	
	private final String ROLE_ADMIN = "ROLE_ADMIN";
	private final String ROLE_STUDENT = "ROLE_STUDENT";
	private final String APPROVED = "Y";

//	@BeforeEach
//	void setup() {
//		this.mockMvc = MockMvcBuilders.webAppContextSetup(ctx)
//				.addFilters(new CharacterEncodingFilter("UTF-8", true))
//				.build();
//	}
	
	@Test
	@DisplayName("????????? ?????? ????????? ??????")
	void class_Enroll_Page() throws Exception{
		
		// given
		LoginSuccessDto login = getLoginInfo();
		
		// when & then
		mockMvc.perform(
					get("/class/enroll-page")
						.sessionAttr(VariableConstant.LOGIN_ATTRIBUTE_NAME, login)
				)
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(view().name("class/class-enroll"))
				;
	}
	
	
	@Test
	@DisplayName("???????????? ?????? ???????????? ????????? ?????? ???????????? ????????? ?????? - AuthenticationException")
	void class_Enroll_Page_Fail_01() throws Exception{
		mockMvc.perform(get("/class/enroll-page"))
			.andDo(print())
			.andExpect(status().is3xxRedirection())
			.andExpect(view().name(UrlPathConstant.REDIRECT_LOGIN_PAGE))
			.andExpect(result -> assertEquals(AuthenticationException.class, result.getResolvedException().getClass()))
			.andExpect(result -> 
				assertEquals(ExceptionMessages.AUTHENTICATION_ERROR.getMessage(), result.getResolvedException().getMessage())
			)
			;
		
	}

	@Test
	@DisplayName("????????? ?????? ???????????? ????????? ?????? ???????????? ????????? ?????? - AuthorizeException")
	void class_Enroll_Page_Fail_02() throws Exception{
		
		LoginSuccessDto login = getStudentLoginInfo();
		
		mockMvc.perform(
				get("/class/enroll-page")
					.sessionAttr(VariableConstant.LOGIN_ATTRIBUTE_NAME, login)
				)
		.andDo(print())
		.andExpect(status().is3xxRedirection())
		.andExpect(view().name(UrlPathConstant.REDIRECT_ROOT_PAGE))
		.andExpect(result -> assertEquals(result.getResolvedException().getClass(), AuthorizeException.class))
		.andExpect(result -> 
			assertEquals(result.getResolvedException().getMessage(), ExceptionMessages.AUTHORIZE_ERROR.getMessage())
		)
		;
		
	}
	
	
	
	
	@Test
	@DisplayName("????????? ??????")
	void class_Enroll_Success() throws Exception{
		
		// given
		LoginSuccessDto login = getLoginInfo();
		String id = login.getId();
		
		String className = "????????? ?????? ?????????";
		String openYear = "2021";
		String openMonth = "11";
		String startDate = "20211111";
		String totalClassCount = "30";
		
		// when
		mockMvc.perform(
					post("/class/enroll")
					.param("className", className)
					.param("openYear", openYear)
					.param("openMonth", openMonth)
					.param("startDate", startDate)
					.param("totalClassCount", totalClassCount)
					.sessionAttr(VariableConstant.LOGIN_ATTRIBUTE_NAME, login)
					)
			.andDo(print())
			.andExpect(status().is3xxRedirection())
			.andExpect(view().name("redirect:/class/manage-page"))
			.andExpect(flash().attributeExists(VariableConstant.MESSAGE))
			.andExpect(flash().attribute(VariableConstant.MESSAGE, "????????? ?????????????????????."))
			;
		
		ClassVO clz = classMapper.findClassByClassName(className);
		
		// then
//		assertThat(clz.getClassSequenceNo()).isNotNull();
//		assertThat(clz.getClassName()).isEqualTo(className);
//		assertThat(clz.getOpenYear()).isEqualTo(openYear);
//		assertThat(clz.getOpenMonth()).isEqualTo(openMonth);
//		assertThat(clz.getStartDate()).isEqualTo(startDate);
//		assertThat(clz.getTotalClassCount()).isEqualTo(Integer.parseInt(totalClassCount));
//		assertThat(clz.getCompleteClassCount()).isEqualTo(0);
//		assertThat(clz.getOpen()).isEqualTo("OPEN");
//		assertThat(clz.getCreatedAt()).isNotNull();
//		assertThat(clz.getCreateAccountId()).isEqualTo(id);
//		assertThat(clz.getModifyAt()).isNotNull();
//		assertThat(clz.getModifyAccountId()).isEqualTo(id);
		
	}

	

	@Test
	@DisplayName("?????? ?????? ?????? ????????? ????????? ?????? ?????????")
	void class_Detail_Manage_Page() throws Exception{
		
		// given
		LoginSuccessDto login = getLoginInfo();
		
		//  when & then
		mockMvc.perform(
						get("/class/classes")
//						.param("open", "CLOSE")
						.sessionAttr(VariableConstant.LOGIN_ATTRIBUTE_NAME, login)
					)
			.andDo(print())
			;
	}
	
	
	@Test
	@DisplayName("????????? ?????? ???????????? ??????")
	void add_Student_Page() throws Exception{
		// given
		LoginSuccessDto login = getLoginInfo();
		String className = "test-className";
		String classSequenceNo = "4";
		
		mockMvc.perform(
				get("/class/classes/{classSequenceNo}/add-student", classSequenceNo)
				.sessionAttr(VariableConstant.LOGIN_ATTRIBUTE_NAME, login)
				.param("className", className)
			)
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(view().name("class/class-add-student"))
			.andExpect(model().attributeExists("className", "classSequenceNo"))
			.andExpect(model().attribute("className", className))
			.andExpect(model().attribute("classSequenceNo", Integer.parseInt(classSequenceNo)))
			;
	}
	

	
	
	private LoginSuccessDto getLoginInfo() {

		String id = "test";
		return LoginSuccessDto.builder()
				.id(id)
				.approved(APPROVED)
				.role(ROLE_ADMIN)
				.accountSequenceNo(1L)
				.build();
	}
	
	private LoginSuccessDto getStudentLoginInfo() {
		String id = "just test";
		return LoginSuccessDto.builder()
				.id(id)
				.approved(APPROVED)
				.role(ROLE_STUDENT)
				.accountSequenceNo(0L)
				.build();
	}


}





































