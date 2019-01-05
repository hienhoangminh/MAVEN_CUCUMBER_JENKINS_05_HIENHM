package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUI.RegisterPageUI;

public class RegisterPageObject extends AbstractPage{
	
	WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		super();
		this.driver = driver;
	}

	public void inputEmailAddress(String email) {
		waitForControlVisible(driver,RegisterPageUI.EMAIL_TEXTBOX);
		sendKeyToElement(driver, RegisterPageUI.EMAIL_TEXTBOX, email);
		
	}

	public void clickSubmitButton() {
		waitForControlVisible(driver,RegisterPageUI.SUBMIT_BUTTON);
		clickOnElement(driver, RegisterPageUI.SUBMIT_BUTTON);
		
	}

	public String getUserIDText() {
		String uId = getTextElement(driver, RegisterPageUI.USERID_VALUE);
		return uId;
	}

	public String getPasswordText() {
		String password = getTextElement(driver, RegisterPageUI.PASSWORD_VALUE);
		return password;
	}

	public LoginPageObject openLoginPage(String loginUrl) {
		openAnyUrl(driver, loginUrl);
		return PageFactoryManager.openLoginPage(driver);
	}

}
