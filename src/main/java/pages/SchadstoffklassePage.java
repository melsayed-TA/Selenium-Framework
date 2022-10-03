package pages;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SchadstoffklassePage extends PageBase{

	//Locators
	@FindBy(xpath ="//div[@aria-label = 'Startseite öffnen']")
	WebElement homeButton;
	
	@FindBy(id="btn-confirm")
	WebElement jaButton;
	
	@FindBy(id="btn-backward")
	WebElement zurueckButton;
	
	
	//Constructor
	public SchadstoffklassePage(WebDriver driver) {
		super(driver);
	}

	
	//Actions/methods
	public void goHome() {
		new WebDriverWait(driver, Duration.ofSeconds(50)).until(ExpectedConditions.elementToBeClickable(homeButton));
		homeButton.click();
		
		new WebDriverWait(driver, Duration.ofSeconds(50)).until(ExpectedConditions.visibilityOf(jaButton));
		new WebDriverWait(driver, Duration.ofSeconds(50)).until(ExpectedConditions.elementToBeClickable(jaButton));
		jaButton.click();
	
	}
	
}
