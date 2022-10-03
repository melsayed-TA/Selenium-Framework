package pages;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class FahrtbeginnPage extends PageBase{
	
	@FindBy(id="btn-forward")
	WebElement weiterButton;
	
	public FahrtbeginnPage(WebDriver driver) {
		super(driver);	
	}

	public ZulassungslandPage klickeWeiterUndNavigiereZurZulassungsland() {
		new WebDriverWait(driver, Duration.ofSeconds(70)).until(ExpectedConditions.visibilityOf(weiterButton));	
		new WebDriverWait(driver, Duration.ofSeconds(70)).until(ExpectedConditions.elementToBeClickable(weiterButton));
		weiterButton.click();
		ZulassungslandPage zulassungslandPage = new ZulassungslandPage(driver);
		return zulassungslandPage;
	}
	
}
