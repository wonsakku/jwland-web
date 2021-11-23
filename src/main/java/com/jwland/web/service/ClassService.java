package com.jwland.web.service;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jwland.domain.account.LoginSuccessDto;
import com.jwland.domain.classes.ClassAccountMapDto;
import com.jwland.domain.classes.ClassAttendanceEnrollDto;
import com.jwland.domain.classes.ClassAttendanceManagementVO;
import com.jwland.domain.classes.ClassDetailDto;
import com.jwland.domain.classes.ClassDomain;
import com.jwland.domain.classes.CreateClassDto;
import com.jwland.domain.classes.EnrolledAccountsDto;
import com.jwland.domain.classes.PersonalClassAttendanceDto;
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
		String nickName = loginSuccessDto.getNickName();
		for(int i = 0 ; i < attendanceList.size() ; i++) {
			PersonalClassAttendanceDto dto = attendanceList.get(i);
			ClassAttendanceManagementVO vo = modelMapper.map(dto, ClassAttendanceManagementVO.class);
			vo.assignCreateAndModifyAccountId(nickName);
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
