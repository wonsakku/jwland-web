package com.jwland.web.admin.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.ss.usermodel.Workbook;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jwland.domain.account.dto.LoginSuccessDto;
import com.jwland.domain.classes.ClassAttendanceManagementVO;
import com.jwland.domain.classes.ClassVO;
import com.jwland.domain.classes.dto.ClassAccountMapDto;
import com.jwland.domain.classes.dto.ClassAttendanceEnrollDto;
import com.jwland.domain.classes.dto.ClassDetailDto;
import com.jwland.domain.classes.dto.ClassListDto;
import com.jwland.domain.classes.dto.CreateClassDto;
import com.jwland.domain.classes.dto.EnrolledAccountsDto;
import com.jwland.domain.classes.dto.PersonalClassAttendanceDto;
import com.jwland.util.CommonUtil;
import com.jwland.util.ExcelUtil;
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
	private final String ATTENDANCE_FILE_NAME_SUFFIX = "_출석_현황";

	public void enrollClass(CreateClassDto createClassDto, HttpServletRequest request) {
		ClassVO clz = modelMapper.map(createClassDto, ClassVO.class);
		String id = getAccountIdFromSession(request);
		clz.assignCreateAndModifyAccountId(id);
		classMapper.enrollClass(clz);
	}

	private String getAccountIdFromSession(HttpServletRequest request) {
		
		HttpSession session = request.getSession(false);
		Object sessionLoginAttr = session.getAttribute(VariableConstant.LOGIN_ATTRIBUTE_NAME);

		if(sessionLoginAttr == null) {
			throw new WrongAccessException();
		}
		return ((LoginSuccessDto) sessionLoginAttr).getId();
	}

	public List<ClassListDto> getClassList(String open) {
		return classMapper.getClassList(open);
	}

	@Transactional
	public int enrollStudentToClass(ClassAccountMapDto classAccountMapDto) {
		int classSequenceNo = classAccountMapDto.getClassSequenceNo();
		List<Integer> accountSequenceList = classAccountMapDto.getAccountSequenceList();
		classMapper.deleteMapTableWithClassSequenceNo(classSequenceNo);
		
		accountSequenceList.sort(Comparator.naturalOrder());
		
		int updateCnt = 0;
		for(int i = 0 ; i < accountSequenceList.size() ; i++) {
			Map<String, Integer> parameter = new HashMap<>();
			parameter.put("classSequenceNo", classSequenceNo);
			parameter.put("accountSequenceNo", accountSequenceList.get(i));
			updateCnt += classMapper.enrollStudentToClass(parameter);
			parameter = null;
		}
		
		return updateCnt;
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

	public ClassDetailDto getClassDetail(int classSequenceNo) {
		return classMapper.getClassDetail(classSequenceNo);
	}

	public void updateClass(ClassDetailDto classDetailDto) {
		int updateCount = classMapper.updateClass(classDetailDto);
		log.info("classUpdateCount : {}", updateCount);
	}

	
	public Workbook getClassAttendanceExcel(int classSequenceNo) throws IOException {
		List<Map<String, String>> classAttendanceInfo = classMapper.findClassAttendanceInfo(classSequenceNo);
		Map<String, String> className = classMapper.getClassName(classSequenceNo);
		String strClassName = className.get("class_name");
		String fileAndSheetName = strClassName + ATTENDANCE_FILE_NAME_SUFFIX;
		
		Workbook excelFile = ExcelUtil.createClassAttendanceExcelFile(classAttendanceInfo, fileAndSheetName);
		
		return excelFile;
	}
	

	public Workbook getClassAttendanceExcel(int classSequenceNo, HttpServletResponse response, HttpServletRequest request) throws IOException {
		List<Map<String, String>> classAttendanceInfo = classMapper.findClassAttendanceInfo(classSequenceNo);
		Map<String, String> className = classMapper.getClassName(classSequenceNo);
		String strClassName = className.get("class_name");
		String fileAndSheetName = strClassName + ATTENDANCE_FILE_NAME_SUFFIX;
		String fileDownloadNmae = "[" + strClassName + "]" + ATTENDANCE_FILE_NAME_SUFFIX;

		Workbook excelFile = ExcelUtil.createClassAttendanceExcelFile(classAttendanceInfo, fileAndSheetName);
		ExcelUtil.excelFileDownload(excelFile, response, request, fileDownloadNmae);
		
		return excelFile;
	}


	
	
}










