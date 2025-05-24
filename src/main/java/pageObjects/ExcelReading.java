package pageObjects;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReading {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String filePath = "G://Book1.xlsx";
		FileInputStream file = new FileInputStream(new File(filePath));
		Workbook wb= new XSSFWorkbook(file);
		Sheet sheet = wb.getSheetAt(0);
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(0);
		System.out.println(cell.getStringCellValue());
		cell.setCellValue("Nags Murali");
		file.close(); // Close the input stream

        // Save the changes
        FileOutputStream fos = new FileOutputStream(new File(filePath));
        wb.write(fos);
        fos.close();
        wb.close();

	}

}
