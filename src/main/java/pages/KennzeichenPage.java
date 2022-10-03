package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class KennzeichenPage extends PageBase{

	@FindBy(id = "license_plate")
	WebElement kennzeichenFeld;
	
	@FindBy(id="btn-forward")
	WebElement weiterButton;
	
	
	public KennzeichenPage(WebDriver driver) {
		super(driver);
	}

	
	public KennzeichenPage setKennzeichenFeld(String kennzeichen) {	//parameterized	
		new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOf(kennzeichenFeld));
		kennzeichenFeld.sendKeys(kennzeichen);
		return this;
	}
	
	public SchadstoffklassePage klickeWeiterUndNavigiereZurSchadstoffklasse() {
		new WebDriverWait(driver, Duration.ofSeconds(50)).until(ExpectedConditions.elementToBeClickable(weiterButton));
		weiterButton.click();
		SchadstoffklassePage schadstoffklassePage = new SchadstoffklassePage(driver);
		return schadstoffklassePage;
	}
	
}
