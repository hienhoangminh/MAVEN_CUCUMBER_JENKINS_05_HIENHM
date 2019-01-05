package stepDefinitions;

import org.openqa.selenium.WebDriver;

import commons.AbstractTest;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberOptions.Hooks;
import pageObjects.PageFactoryManager;
import pageObjects.RegisterPageObject;

public class RegisterStepsDefinition {

	WebDriver driver;
	private RegisterPageObject registerPage;
	AbstractTest abstractTest;
	static String userId,userPass;

	public RegisterStepsDefinition() {
		driver = Hooks.openBrowser();
		registerPage = PageFactoryManager.openRegisterPage(driver);
		abstractTest = new AbstractTest();
	}
	
	@When("^I input to email textbox with data \"([^\"]*)\"$")
	public void iInputToEmailTextboxWithData(String email){
		registerPage.inputEmailAddress(email+abstractTest.randomNum()+"@gmail.com");
	}


	@When("^I click to Submit button$")
	public void iClickToSubmitButton() {
		registerPage.clickSubmitButton();
	}

	@Then("^I get UserID info$")
	public void iGetUserIDInfo() {
		userId = registerPage.getUserIDText().trim();
	}

	@Then("^I get password info$")
	public void iGetPasswordInfo() {
		userPass = registerPage.getPasswordText().trim();
    }
	

	@When("^I open Login page again$")
	public void iOpenLoginPageAgain() {
	    registerPage.openLoginPage(LoginStepsDefinition.loginPageUrl);
	}
	
}
