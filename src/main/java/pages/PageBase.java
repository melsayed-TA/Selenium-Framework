package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

//Note: All page classes will inherit from this PageBase class. 
//This class contains the web driver, so it's the "base" for all page classes

public class PageBase {

	protected WebDriver driver;
	
	//Constructor 
	public PageBase (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	//Generic function for clicking on buttons
	/*public static void clickButton(WebElement button) {
		button.click();
	}*/
	
	//Generic function for setting text in a text field
	/*public static void setText(WebElement textfieldElement, String text) {
		textfieldElement.sendKeys(text);
	}*/
	
	//These functions (methods) can be used in all the pages that have inherited from the PageBase!
	
}
