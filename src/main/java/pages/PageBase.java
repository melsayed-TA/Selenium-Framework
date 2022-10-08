package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

//Note: All page classes will inherit from this PageBase class. 
//This class contains the web driver, so it's the "base" for all page classes, in other words after all the pages classes inherit from this class
//the web driver will be also inherited and it will be used to do locate and perform actions on the web elements of these pages.

public class PageBase {

	protected WebDriver driver;
	
	//Constructor 
	public PageBase (WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}	
}
