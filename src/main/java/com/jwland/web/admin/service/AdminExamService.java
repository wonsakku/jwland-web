package com.jwland.web.admin.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.jwland.domain.exam.ExamDuplicationValidateParameter;
import com.jwland.domain.exam.ExamEnrollDto;
import com.jwland.domain.exam.ExamUpdateDto;
import com.jwland.util.ExcelUtil;
import com.jwland.web.admin.mapper.AdminExamMapper;
import com.jwland.web.constant.ExceptionMessages;
import com.jwland.web.exception.AlreadyEnrolledException;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service
public class AdminExamService {

	private static final String FILE_EXAM_STATISTIC_SUFFIX = "오답_통계";
	private static final String YEAR_SPLITOR = "~";
	private final AdminExamMapper adminExamMapper;
	private final ModelMapper modelMapper;
	
	private final String UNDERSCORE = "_";
	private final String FILE_NAME_OPENNER = "[";
	private final String FILE_NAME_CLOSURE = "]";
	
	public void enrollExam(ExamEnrollDto examEnrollDto) {
		
		examDuplicationCheck( modelMapper.map(examEnrollDto, ExamDuplicationValidateParameter.class) );
		adminExamMapper.enrollExam(examEnrollDto);
	}

	public void updateExamType(ExamUpdateDto examUpdateDto) {
		examDuplicationCheck( modelMapper.map(examUpdateDto, ExamDuplicationValidateParameter.class) );
		adminExamMapper.updateExamType(examUpdateDto);
	}
	
	private void examDuplicationCheck(ExamDuplicationValidateParameter parameter) {
		
		Map<String, String> duplicateCheckMap = adminExamMapper.checkExamExist(parameter);
		if(duplicateCheckMap != null) {
			throw new AlreadyEnrolledException(ExceptionMessages.ALREADY_ENROLLED_EXAM);
		}
	}

	public void deleteExamType(int examTypeSequenceNo) {
		int deleteCount = adminExamMapper.deleteExamType(examTypeSequenceNo);
		if(deleteCount < 1) {
			throw new IllegalArgumentException(ExceptionMessages.NO_MATCHED_EXAM.getMessage());
		}
	}

	public void excelDownload(Map<String, String> parameter, HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String start = parameter.get("start");
		String end = parameter.get("end");
		
		
		List<Map> subjectInfoList = adminExamMapper.getSubjectInfo(parameter);
		
		Workbook workbook = new XSSFWorkbook();
		String subjectNames = "";
		
		for(int i = 0 ; i < subjectInfoList.size() ; i++) {
			
			if(i > 0) {
				subjectNames += UNDERSCORE;
			}
			
			Map subjectInfo = subjectInfoList.get(i);
			String examSubjectCode =  subjectInfo.get("exam_subject_code").toString();
			
			Map newParameter = new HashMap<>();
			newParameter.put("start", Integer.parseInt(start));
			newParameter.put("end", Integer.parseInt(end));
			newParameter.put("examSubjectCode", examSubjectCode);
			List<Map> wrongProblemStatistic = adminExamMapper.getExamStatistic(newParameter);
			
			String sheetName = subjectInfo.get("subject").toString();
			ExcelUtil.setExamStatiscInfo(wrongProblemStatistic, workbook, sheetName);
			
			subjectNames += subjectInfo.get("subject");
		}
		
		String fileTitle = FILE_NAME_OPENNER;
		fileTitle += start + YEAR_SPLITOR + end + subjectNames;
		fileTitle += FILE_NAME_CLOSURE;
		fileTitle += FILE_EXAM_STATISTIC_SUFFIX;
		
		ExcelUtil.excelFileDownload(workbook, response, request, fileTitle);
	}


}






















