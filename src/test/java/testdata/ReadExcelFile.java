package testdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelFile 
{

	static FileInputStream fis = null;
	
	public FileInputStream readExcelFileData() {
		
		String filePath = System.getProperty("user.dir") + "\\src\\test\\java\\testdata\\TestData.xlsx";
		File sourceFile = new File(filePath);
		
		try {
			fis = new FileInputStream(sourceFile);
		} catch (FileNotFoundException e) {
			System.out.println("Error occurred while reading data from excel (Excel data file not found, please check!): " + e.getMessage());
			System.exit(0);
		}
		
		return fis;
	}
	
	
	public Object [][] getExcelData() throws IOException{

		
		fis = readExcelFileData();
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheetAt(0);
		int rowsCount = sheet.getLastRowNum()+1;
		int coloumnsCount = 2;	//2 coloumns
		
		String [][] arrExcelData = new String[rowsCount][coloumnsCount];
		
		for (int i = 0; i < rowsCount; i++) {
			
			for (int j = 0; j < coloumnsCount; j++) {
				XSSFRow row = sheet.getRow(i);
				arrExcelData[i][j] = row.getCell(j).toString();
			}
		}
		
		workbook.close();
		return arrExcelData;
	}
	
}
