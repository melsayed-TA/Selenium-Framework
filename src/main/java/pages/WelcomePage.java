package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WelcomePage extends PageBase {

	@FindBy(id="btn_login")
	WebElement loginButton;
	
	@FindBy(id="btn_start_booking")
	WebElement streckeEinbuchenButton;
	
	@FindBy(id ="language_de")
	WebElement deutschSpracheButton;
	
	public WelcomePage(WebDriver driver) 
	{
		super(driver);	//initializing the constructor of the super class (PageBase) with the driver
	}

	public void offeneLoginMaske() {
		
		loginButton.click();
	}
	
	public WelcomePage auswaehleSpracheDeutsch() {
		new WebDriverWait(driver, Duration.ofSeconds(80)).until(ExpectedConditions.visibilityOf(deutschSpracheButton));	
		new WebDriverWait(driver, Duration.ofSeconds(50)).until(ExpectedConditions.elementToBeClickable(deutschSpracheButton));
		deutschSpracheButton.click();
		return this;
	}
	
	public FahrtbeginnPage starteEinbuchung() {
		streckeEinbuchenButton.click();
		FahrtbeginnPage fahrtbeginnPage = new FahrtbeginnPage(driver);
		return fahrtbeginnPage;	 //return the next page/mask
	}
	
}
