package utils;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	private static Workbook workbook;
	private static Sheet sheet;
	
	public static void setExcel(String path,String sheetName) throws IOException{
	
		FileInputStream file=new FileInputStream(path);
		workbook=new XSSFWorkbook(file);//read xlsx files; if old format, use: HSSFWorkbook
		sheet=workbook.getSheet(sheetName); 
		
			}
	
	public static int getRowCount() {
		return sheet.getPhysicalNumberOfRows();
	}
	
	public static int getCellCount() {
		return sheet.getRow(0).getPhysicalNumberOfCells();
	}
	
	public static String getCellData(int rowNum,int colNum) {
		
		Row row=sheet.getRow(rowNum);
		Cell cell=row.getCell(colNum);
		return cell.getStringCellValue();
	}
	
	public static String[][] getDataArray(String filepath,String sheetName) throws IOException{
		setExcel(filepath,sheetName);
		int rowCount= getRowCount();
		int colCount=getCellCount();
		String[][] arr=new String[rowCount-1][colCount];
		for(int i=0;i<rowCount-1;i++) {
			for(int j=0;j<colCount;j++) {
				arr[i][j]=getCellData(i,j);
			}
		}
		return arr;
	}
	
	public static void main(String[] args) throws IOException {
		
		//FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/sample.xlsx");
		String[][] arr=getDataArray(System.getProperty("user.dir")+"/src/main/resources/sample.xlsx","Sheet1");
		for(int i=0;i < arr.length; i++) {
			for(int j=0;j<arr.length;j++) {
				System.out.println(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
}

