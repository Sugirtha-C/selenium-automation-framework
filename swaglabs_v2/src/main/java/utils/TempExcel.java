package utils;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class TempExcel {

	//private static Properties properties=new Properties();
	public static void main(String[] args) throws IOException {
		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/sample.xlsx");
		//properties.load(file);
		Workbook workbook=new XSSFWorkbook(file);
		Sheet sheet=workbook.getSheet("Sheet1");
		System.out.println(sheet.getPhysicalNumberOfRows());
		System.out.println("total cells:" +sheet.getRow(0).getPhysicalNumberOfCells());
		System.out.println("Data in cell is: "+sheet.getRow(1).getCell(1).getStringCellValue());
		
	}
}
