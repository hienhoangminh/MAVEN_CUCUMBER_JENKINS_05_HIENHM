package stepDefinitions;

import org.openqa.selenium.WebDriver;

import commons.AbstractTest;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumberOptions.Hooks;
import pageObjects.LoginPageObject;
import pageObjects.PageFactoryManager;

public class LoginStepsDefinition {

	WebDriver driver;
	private LoginPageObject loginPage;
	static String loginPageUrl;
	AbstractTest abstractTest;

	public LoginStepsDefinition() {
		driver = Hooks.openBrowser();
		loginPage = PageFactoryManager.openLoginPage(driver);
		abstractTest = new AbstractTest();
	}
	
	@When("^I get login page URL$")
	public void iGetLoginLink() {
		loginPageUrl = loginPage.getPageCurrentUrl(driver);
	}
	
	@When("^I click to here link$")
	public void iClickToHereLink(){
		loginPage.clickHereLinkToOpenRegisterPage();
	}
	
	@Given("^I input to UserID textbox$")
	public void iInputToUserIDTextbox() throws Throwable {
		loginPage.inputToUserIDTextBox(RegisterStepsDefinition.userId);
	}

	@Given("^I input to Password textbox$")
	public void iInputToPasswordTextbox() throws Throwable {
		loginPage.inputToPasswordTextBox(RegisterStepsDefinition.userPass);
	}

	@Given("^I click to Login button at Login page$")
	public void iClickToLoginButtonAtLoginPage(){
		loginPage.clickLoginButton();
	}
}
