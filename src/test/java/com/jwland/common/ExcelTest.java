package com.jwland.common;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Workbook;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jwland.web.admin.service.AdminClassService;

@SpringBootTest
public class ExcelTest {

	@Autowired AdminClassService adminAccountService;
	
	@Test
	void excelTest() throws IOException {
		Workbook workbook = adminAccountService.getClassAttendanceExcel(1);
		
		
		try(FileOutputStream out = new FileOutputStream(new File("exceltest.xlsx"))) {
			workbook.write(out);
			out.close();
		}
	}
}
