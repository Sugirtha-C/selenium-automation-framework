package utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {

	private static Workbook workbook;
	private static Sheet sheet;
	private  Map<String, String> testresults = new HashMap<>();
	
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
		DataFormatter formatter=new DataFormatter();
		return formatter.formatCellValue(cell);
}
	
	public static Object[][] getDataArray(String filepath, String sheetName) throws IOException {
        setExcel(filepath, sheetName);
        int rowCount = getRowCount();
        int colCount = getCellCount();
        Object[][] arr = new Object[rowCount-1][colCount];
        for (int i = 1; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                arr[i-1][j] = getCellData(i, j);
            }
        }
        workbook.close();
        return arr;
    }

	public void recordTestResult(String name, String status) {
		testresults.put(name, status);
	}

	public void writeTestResultsToExcel(String filepath) throws IOException {
		workbook=new XSSFWorkbook();
		Sheet sheet=workbook.createSheet("TestResults");
		Row header=sheet.createRow(0);
		header.createCell(0).setCellValue("TestcaseName");
		header.createCell(1).setCellValue("Status");	
		int rowNum=1;	
		//what for loop is doing-->it is used to loop through the map 
		//and write the values to excel
		for(Map.Entry<String, String> entry:testresults.entrySet()) {	
			Row row=sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(entry.getKey());
			row.createCell(1).setCellValue(entry.getValue());
		}
		
		FileOutputStream file=new FileOutputStream(filepath);
		workbook.write(file);
		workbook.close();
		file.close();
	}
	
	/*public static void main(String[] args) throws IOException {
    Object[][] arr = getDataArray(System.getProperty("user.dir") + "/src/main/resources/CreateAccounts.xlsx", "Sheet1");
    for (int i = 0; i < arr.length; i++) {
        for (int j = 0; j < arr[i].length; j++) {
            System.out.print(arr[i][j] + " ");
        }
        System.out.println();
    }
}/*
	/*public static String getCellData(int rowNum,int colNum) {
		
		Row row=sheet.getRow(rowNum);
		Cell cell=row.getCell(colNum);
		return cell.getStringCellValue();
	}*/
	
	/*public static Object[][] getDataArray(String filepath,String sheetName) throws IOException{
		setExcel(filepath,sheetName);
		int rowCount= getRowCount();
		int colCount=getCellCount();
		Object[][] arr=new Object[rowCount-1][colCount];
		for(int i=0;i<rowCount-1;i++) {
			for(int j=0;j<colCount;j++) {
				arr[i][j]=getCellData(i,j);
			}
		}
		workbook.close();
		return arr;
	}*/
	
	

	
	/*public static void main(String[] args) throws IOException {
		
		//FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"/src/main/resources/sample.xlsx");
		Object[][] arr=getDataArray(System.getProperty("user.dir")+"/src/main/resources/CreateAccounts.xlsx","Sheet1");
		for(int i=0;i < arr.length; i++) {
			for(int j=0;j<arr.length;j++) {
				System.out.println(arr[i][j]+" ");
			}
			System.out.println();
		}
	}*/
	
	/*public static void main(String[] args) throws IOException {
        Object[][] arr = getDataArray(System.getProperty("user.dir") + "/src/main/resources/CreateAccounts.xlsx", "Sheet1");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
*/
}
