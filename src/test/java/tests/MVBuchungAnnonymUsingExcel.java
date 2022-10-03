package tests;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pages.WelcomePage;
import testdata.ReadExcelFile;


public class MVBuchungAnnonymUsingExcel extends TestBase{
	
	//Data driven testing with the TestNG annotation --> @DataProvider
	@DataProvider(name="MVTestData")
	public static Object[][] testData() throws IOException
	{
		//Get data from excel reader class (Read excel file)
		ReadExcelFile excelReader = new ReadExcelFile();
		Object[][] arrExcelData =  excelReader.getExcelData();
		return arrExcelData;
	}
	
	@Test(dataProvider = "MVTestData")
	public void durchfuehrenMVEinbuchung(String zulassungsland, String kennzeichen) {
		WelcomePage welcomePage = new WelcomePage(driver); 
		welcomePage.auswaehleSpracheDeutsch()
					.starteEinbuchung()
					.klickeWeiterUndNavigiereZurZulassungsland()
					.klickeAufZulassungsland(zulassungsland)
					.klickeWeiterUndNavigiereZurKennzeichen()
					.setKennzeichenFeld(kennzeichen)
					.klickeWeiterUndNavigiereZurSchadstoffklasse()
					.goHome();
	}
}
