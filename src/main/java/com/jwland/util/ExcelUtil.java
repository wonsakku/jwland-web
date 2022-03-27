package com.jwland.util;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

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
	
	private static final List<String> CLASS_ATTENDANCE_HEADER = Arrays.asList("학교", "학년", "이름", "날짜", "출석상태"); 
	
	
	public static Workbook createClassAttendanceExcelFile(List<Map<String, String>> dataList, String fileName, String sheetName) {
		
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
	
}














