package com.jwland.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtil {

	
//	public static final String EXCEL_CONTENT_TYPE = "ms-vnd/excel";
	public static final String EXCEL_CONTENT_TYPE = "application/octet-stream";
	public static final String EXCEL_HEADER_KEY = "Content-Disposition";
	public static final String EXCEL_HEADER_VALUE_PREFIX = "attachment;filename=";
	public static final String EXCEL_EXT = ".xlsx";
	
	private static final String USER_AGENT = "User-Agent";

	private static final List<String> CLASS_ATTENDANCE_HEADER = Arrays.asList("학교", "학년", "이름", "날짜", "출석상태"); 
	private static final List<String> EXAM_STATISTIC_HEADER = Arrays.asList("시험연도", "월", "시험 기관", "번호", "오답자수");
	
	public static void setExamStatiscInfo(List<Map> dataList, Workbook wb, String sheetName) {
		Sheet sheet = wb.createSheet(sheetName);
		Row row = null;
		int rowNum = 0;
		
		row = sheet.createRow(rowNum++);
		
		setExcelHeader(EXAM_STATISTIC_HEADER, row);
		
		Cell cell = null;
		
		for(int i = 0 ; i < dataList.size() ; i++) {
			Map data = dataList.get(i);
			
			row = sheet.createRow(rowNum + i);
			cell = row.createCell(0);
			cell.setCellValue(data.get("year") + "");
			
			cell = row.createCell(1);
			cell.setCellValue(data.get("month") + "");
			
			cell = row.createCell(2);
			cell.setCellValue(data.get("exam_organization_name") + "");
			
			cell = row.createCell(3);
			cell.setCellValue(data.get("problem_number") + "");
			
			cell = row.createCell(4);
			cell.setCellValue(data.get("wrong_count") + "");
		}
	}
	
	public static Workbook createClassAttendanceExcelFile(List<Map<String, String>> dataList, String sheetName) {
		
		Workbook wb= new XSSFWorkbook();
		
		Sheet sheet = wb.createSheet(sheetName);
		Row row = null;
		int rowNum = 0;
		
		row = sheet.createRow(rowNum++);
		
		setExcelHeader(CLASS_ATTENDANCE_HEADER, row);
		
		Cell cell = null;
		for(int i = 0 ; i < dataList.size() ; i++) {
			Map<String, String> data = dataList.get(i);
			row = sheet.createRow(rowNum + i);
			cell = row.createCell(0);
			cell.setCellValue(data.get("school_name"));
			
			cell = row.createCell(1);
			cell.setCellValue(data.get("grade"));
			
			cell = row.createCell(2);
			cell.setCellValue(data.get("name"));
			
			cell = row.createCell(3);
			cell.setCellValue(data.get("class_date"));
			
			cell = row.createCell(4);
			cell.setCellValue(data.get("attendance_status"));
		}
		
		return wb;
	}
	
	
	private static void setExcelHeader(List<String> headerList, Row row) {
		Cell cell = null;
		
		for(int i = 0 ; i < headerList.size() ; i++) {
			cell = row.createCell(i);
			cell.setCellValue(headerList.get(i));
		}
	}
	
	
	public static void excelFileDownload(Workbook excelFile, HttpServletResponse response, HttpServletRequest request, String fileName) throws IOException {
		
		String agent = request.getHeader(USER_AGENT);
		
		fileName = encodingFileNmae(fileName, agent);
		
		response.setContentType(ExcelUtil.EXCEL_CONTENT_TYPE);
		response.setHeader(ExcelUtil.EXCEL_HEADER_KEY, ExcelUtil.EXCEL_HEADER_VALUE_PREFIX + fileName + ExcelUtil.EXCEL_EXT);
		excelFile.write(response.getOutputStream());
		excelFile.close();
	}


	
	private static String encodingFileNmae(String fileName, String agent) {
		
		String encodedFileName = "";
		
        try {
			if(agent.contains("Trident"))//Internet Explore
				encodedFileName = URLEncoder.encode(fileName, "UTF-8").replaceAll("\\+", " ");
			    
			else if(agent.contains("Edge")) //Micro Edge
				encodedFileName = URLEncoder.encode(fileName, "UTF-8");
			else //Chrome
				encodedFileName = new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return encodedFileName;
	}
	
}














