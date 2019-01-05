package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import commons.AbstractPage;
import pageUI.AbstractPageUI;
import pageUI.HomePageUI;

public class HomePageObject extends AbstractPage{
	
	WebDriver driver;
	WebDriverWait wait;
	
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void verifyMessageVisible() {
		waitForControlVisible(driver, HomePageUI.MESSAGE_TEXT);
		Assert.assertTrue(isControlDisplayed(driver, HomePageUI.MESSAGE_TEXT));
		
	}
	
	public boolean isHomepPageDisplayed(String message) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_MESSAGE_TEXT,message);
		return isControlDisplayed(driver, AbstractPageUI.DYNAMIC_MESSAGE_TEXT,message);
		
	}
	
	

}
