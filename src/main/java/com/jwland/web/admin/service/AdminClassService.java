package com.jwland.web.admin.service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jwland.domain.account.dto.LoginSuccessDto;
import com.jwland.domain.classes.ClassAttendanceManagementVO;
import com.jwland.domain.classes.ClassVO;
import com.jwland.domain.classes.dto.ClassAccountMapDto;
import com.jwland.domain.classes.dto.ClassAttendanceEnrollDto;
import com.jwland.domain.classes.dto.ClassDetailDto;
import com.jwland.domain.classes.dto.CreateClassDto;
import com.jwland.domain.classes.dto.EnrolledAccountsDto;
import com.jwland.domain.classes.dto.PersonalClassAttendanceDto;
import com.jwland.web.admin.mapper.AdminClassMapper;
import com.jwland.web.constant.VariableConstant;
import com.jwland.web.exception.WrongAccessException;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@Service
public class AdminClassService {

	private final AdminClassMapper classMapper;
	private final ModelMapper modelMapper;

	public void enrollClass(CreateClassDto createClassDto, HttpServletRequest request) {
		ClassVO clz = modelMapper.map(createClassDto, ClassVO.class);
		String id = getNickNameFromSession(request);
		clz.assignCreateAndModifyAccountId(id);
		classMapper.enrollClass(clz);
	}

	private String getNickNameFromSession(HttpServletRequest request) {
		
		HttpSession session = request.getSession(false);
		Object sessionLoginAttr = session.getAttribute(VariableConstant.LOGIN_ATTRIBUTE_NAME);

		if(sessionLoginAttr == null) {
			throw new WrongAccessException();
		}
		
		return ((LoginSuccessDto) sessionLoginAttr).getId();
	}

	public List<ClassDetailDto> getClassDetails(String open) {
		return classMapper.getClassDetails(open);
	}

	@Transactional
	public void enrollStudentToClass(ClassAccountMapDto classAccountMapDto) {
		int classSequenceNo = classAccountMapDto.getClassSequenceNo();
		List<Integer> accountSequenceList = classAccountMapDto.getAccountSequenceList();
		classMapper.deleteMapTableWithClassSequenceNo(classSequenceNo);
		
		accountSequenceList.sort(Comparator.naturalOrder());
		
		for(int i = 0 ; i < accountSequenceList.size() ; i++) {
			Map<String, Integer> parameter = new HashMap<>();
			parameter.put("classSequenceNo", classSequenceNo);
			parameter.put("accountSequenceNo", accountSequenceList.get(i));
			classMapper.enrollStudentToClass(parameter);
			parameter = null;
		}
		
	}

	public List<Integer> getEnrolledAccounts(int classSequenceNo) {
		return classMapper.getEnrolledAccounts(classSequenceNo);
	}

	public List<EnrolledAccountsDto> getEnrolledAccountInfos(int classSequenceNo) {
		return classMapper.getEnrolledAccountInfos(classSequenceNo);
	}

	public List<String> getClassDate(int classSequenceNo) {
		return classMapper.getClassDate(classSequenceNo);
	}

	@Transactional
	public void classAttendanceEnroll(ClassAttendanceEnrollDto classAttendanceEnrollDto, HttpServletRequest request) {
		int classSequenceNo = classAttendanceEnrollDto.getClassSequenceNo();
		String classDate = classAttendanceEnrollDto.getClassDate();
		Map<String, String> parameter = new HashMap<>();
		parameter.put("classSequenceNo", classSequenceNo + "");
		parameter.put("classDate", classDate);
		classMapper.deleteClassAttendanceInfo(parameter);
		List<PersonalClassAttendanceDto> attendanceList = classAttendanceEnrollDto.getAttendanceInfo();
		HttpSession session = request.getSession();
		LoginSuccessDto loginSuccessDto = (LoginSuccessDto) session.getAttribute(VariableConstant.LOGIN_ATTRIBUTE_NAME);
		String id = loginSuccessDto.getId();
		
		for(int i = 0 ; i < attendanceList.size() ; i++) {
			PersonalClassAttendanceDto dto = attendanceList.get(i);
			ClassAttendanceManagementVO vo = modelMapper.map(dto, ClassAttendanceManagementVO.class);
			vo.assignCreateAndModifyAccountId(id);
			vo.setClassSequenceNo(classSequenceNo);
			vo.setClassDate(classDate);
			classMapper.enrollAttendanceInfo(vo);
			
		}
	}

	public List<PersonalClassAttendanceDto> findAttendanceInfoByDate(String classDate, int classSequenceNo) {
		Map<String, String> parameter = new HashMap<>();
		parameter.put("classDate", classDate);
		parameter.put("classSequenceNo", classSequenceNo + "");
		return classMapper.findAttendanceInfoByDate(parameter);
	}
	
	
	
}
