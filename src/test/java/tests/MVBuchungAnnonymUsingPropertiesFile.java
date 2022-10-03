package tests;

import org.testng.annotations.Test;
import pages.WelcomePage;
import testdata.ReadPropertiesFile;

public class MVBuchungAnnonymUsingPropertiesFile extends TestBase{
	
	//Read the test data from the properties file
	private String zulassungsland	= ReadPropertiesFile.userData.getProperty("zulassungsland");
	private String kennzeichen 		= ReadPropertiesFile.userData.getProperty("kennzeichen");

	
	@Test()
	public void durchfuehrenMVEinbuchung() {
		
		String [] arrZulassungsland = zulassungsland.split(",");
		String [] arrkennzeichen 	= kennzeichen.split(",");
		
		int arrLength = arrZulassungsland.length;
		for (int i = 0; i < arrLength; i++) 
		{
			System.out.println("Iteration number/Test number --> " + Integer.toString(i+1));
			System.out.println("Zulassungsland to be used --> " + arrZulassungsland[i]);
			System.out.println("Kennzeichen to be used --> " + arrkennzeichen[i]);
		
			//Print, to make sure data is correctly read from the properties file
			System.out.println("Data from data provider, zulassungsland: " + zulassungsland);
			System.out.println("Data from data provider, kennzeichen: " + kennzeichen);
		
			//Test Case
			WelcomePage welcomePage = new WelcomePage(driver); 
			welcomePage.auswaehleSpracheDeutsch()
						.starteEinbuchung()
						.klickeWeiterUndNavigiereZurZulassungsland()
						.klickeAufZulassungsland(arrZulassungsland[i])			
						.klickeWeiterUndNavigiereZurKennzeichen()
						.setKennzeichenFeld(arrkennzeichen[i])
						.klickeWeiterUndNavigiereZurSchadstoffklasse()
						.goHome();
		}
		
	}
}
