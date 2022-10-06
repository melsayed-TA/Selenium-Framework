package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ZulassungslandPage extends PageBase{
	
	@FindBy(id = "icon-tile-DE")
	WebElement deutschlandButton;
	
	@FindBy(id = "icon-tile-PL")
	WebElement polenButton;
	
	@FindBy(id="btn-forward")
	WebElement weiterButton;
	
	public ZulassungslandPage(WebDriver driver) {
		super(driver);
	}


	public ZulassungslandPage klickeAufZulassungsland(String zulassungsland) {
		
		if (zulassungsland.contains("DE")) {
			new WebDriverWait(driver, Duration.ofSeconds(50)).until(ExpectedConditions.visibilityOf(deutschlandButton));	
			new WebDriverWait(driver, Duration.ofSeconds(50)).until(ExpectedConditions.elementToBeClickable(deutschlandButton));
			deutschlandButton.click();
		}
		
		else if (zulassungsland.contains("PL")) 
		{
			new WebDriverWait(driver, Duration.ofSeconds(50)).until(ExpectedConditions.visibilityOf(polenButton));	
			new WebDriverWait(driver, Duration.ofSeconds(50)).until(ExpectedConditions.elementToBeClickable(polenButton));
			polenButton.click();
		}
		
		return this; //returning the same object! (For using fluent design)
	}
	
	public KennzeichenPage klickeWeiterUndNavigiereZurKennzeichen() {
		new WebDriverWait(driver, Duration.ofSeconds(50)).until(ExpectedConditions.visibilityOf(weiterButton));	
		new WebDriverWait(driver, Duration.ofSeconds(50)).until(ExpectedConditions.elementToBeClickable(weiterButton));
		weiterButton.click();
		KennzeichenPage kennzeichenPage = new KennzeichenPage(driver);
		return kennzeichenPage;
	}
	
}
