package tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.WelcomePage;

public class MVBuchungAnnonym extends TestBase{
	
	//private String kennzeichen = "HH AB 123";		//Static value!
	
	//Data driven testing with the TestNG annotation --> @DataProvider
	@DataProvider(name="MVTestData")
	public static Object[][] testData()
	{
		Object[][] testDataForDDT = new Object[][] { {"DE", "HH AB 123"}, {"PL", "SG 49125"} };
		return testDataForDDT;
	}
	
	
	@Test(dataProvider = "MVTestData")
	public void durchfuehrenMVEinbuchung(String zulassungsland, String kennzeichen) {	
		//Fluent design!
		WelcomePage welcomePage = new WelcomePage(driver); //Taking an object from WelcomePage to start the test case from
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
