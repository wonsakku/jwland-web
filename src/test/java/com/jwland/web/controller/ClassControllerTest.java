package com.jwland.web.controller;

import static org.assertj.core.api.Assertions.assertThat;
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

import com.jwland.domain.account.LoginSuccessDto;
import com.jwland.domain.classes.ClassDomain;
import com.jwland.web.constant.VariableConstant;
import com.jwland.web.mapper.ClassMapper;
import com.jwland.web.service.ClassService;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class ClassControllerTest {


	@Autowired MockMvc mockMvc;
	@Autowired ClassService classService;
	@Autowired ClassMapper classMapper;
	
	
	private final String ROLE_ADMIN = "ROLE_ADMIN";
	private final String APPROVED = "Y";

	
	@Test
	@DisplayName("클래스 등록 페이지로 이동")
	void class_Enroll_Page() throws Exception{
		mockMvc.perform(get("/class/enroll-page"))
			.andDo(print())
			.andExpect(status().isOk())
			.andExpect(view().name("class/class-enroll"))
			.andExpect(model().attributeExists("createClassDto"))
			;
	}
	
	
	@Test
	@DisplayName("클래스 등록")
	void class_Enroll_Success() throws Exception{
		
		// given
		String nickName = "jwland";
		LoginSuccessDto login = LoginSuccessDto.builder()
				.nickName(nickName)
				.approved(APPROVED)
				.role(ROLE_ADMIN)
				.accountSequenceNo(4L)
				.build();
		
		String className = "클래스 등록 테스트";
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
			.andExpect(flash().attribute(VariableConstant.MESSAGE, "강의가 등록되었습니다."))
			;
		
		ClassDomain clz = classMapper.findClassByClassName(className);
		
		// then
		assertThat(clz.getClassSequenceNo()).isNotNull();
		assertThat(clz.getClassName()).isEqualTo(className);
		assertThat(clz.getOpenYear()).isEqualTo(openYear);
		assertThat(clz.getOpenMonth()).isEqualTo(openMonth);
		assertThat(clz.getStartDate()).isEqualTo(startDate);
		assertThat(clz.getTotalClassCount()).isEqualTo(Integer.parseInt(totalClassCount));
		assertThat(clz.getCompleteClassCount()).isEqualTo(0);
		assertThat(clz.getOpen()).isEqualTo("OPEN");
		assertThat(clz.getCreatedAt()).isNotNull();
		assertThat(clz.getCreateAccountId()).isEqualTo(nickName);
		assertThat(clz.getModifyAt()).isNotNull();
		assertThat(clz.getModifyAccountId()).isEqualTo(nickName);
		
	}
	
}





































