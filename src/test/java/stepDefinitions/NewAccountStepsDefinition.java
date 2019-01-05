package stepDefinitions;

import org.openqa.selenium.WebDriver;

import commons.AbstractTest;
import cucumber.api.java.en.When;
import cucumberOptions.Hooks;
import pageObjects.NewAccountPageObject;
import pageObjects.PageFactoryManager;

public class NewAccountStepsDefinition {

	static WebDriver driver;
	private NewAccountPageObject newAccountPage;
	private AbstractTest abstractTest;
	static String accoutId;


	public NewAccountStepsDefinition() {
		driver = Hooks.openBrowser();
		newAccountPage = PageFactoryManager.openNewAccountPage(driver);
		abstractTest = new AbstractTest();
	}
	
	@When("^I can get AccountId info$")
	public void iCanGetAccountIdInfo(){
		accoutId = newAccountPage.getAccountId();
	}
	
}
