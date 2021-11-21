package com.jwland.web.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.jwland.domain.account.LoginSuccessDto;
import com.jwland.domain.classes.ClassDomain;
import com.jwland.domain.classes.CreateClassDto;
import com.jwland.web.constant.VariableConstant;
import com.jwland.web.exception.WrongAccessException;
import com.jwland.web.mapper.ClassMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class ClassService {

	private final ClassMapper classMapper;
	private final ModelMapper modelMapper;

	public void enrollClass(CreateClassDto createClassDto, HttpServletRequest request) {
		ClassDomain clz = modelMapper.map(createClassDto, ClassDomain.class);
		String nickName = getNickNameFromSession(request);
		clz.assignCreateAndModifyAccountId(nickName);
		classMapper.enrollClass(clz);
	}

	private String getNickNameFromSession(HttpServletRequest request) {
		
		HttpSession session = request.getSession(false);
		Object sessionLoginAttr = session.getAttribute(VariableConstant.LOGIN_ATTRIBUTE_NAME);

		if(sessionLoginAttr == null) {
			throw new WrongAccessException();
		}
		
		return ((LoginSuccessDto) sessionLoginAttr).getNickName();
	}
	
	
	
}
