package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUI.LoginPageUI;

public class LoginPageObject extends AbstractPage{

	WebDriver driver;
	

	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}


	public String getLoginPageUrl() {
		return getPageCurrentUrl(driver);
	}


	public void inputToUserIDTextBox(String value) {
		waitForControlVisible(driver, LoginPageUI.USER_ID_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.USER_ID_TEXTBOX, value);
	}
	
	public void inputToPasswordTextBox(String password) {
		waitForControlVisible(driver, LoginPageUI.USER_PASSWORD_TEXTBOX);
		sendKeyToElement(driver, LoginPageUI.USER_PASSWORD_TEXTBOX, password);
	}


	public HomePageObject clickLoginButton() {
		waitForControlVisible(driver, LoginPageUI.USER_PASSWORD_TEXTBOX);
		clickOnElement(driver, LoginPageUI.BUTTON_LOGIN);
		return PageFactoryManager.openHomePage(driver);
		
	}

	public RegisterPageObject clickHereLinkToOpenRegisterPage() {
		waitForControlVisible(driver, LoginPageUI.HERE_LINK);
		clickOnElement(driver, LoginPageUI.HERE_LINK);
		return PageFactoryManager.openRegisterPage(driver);		
	}
	
}
