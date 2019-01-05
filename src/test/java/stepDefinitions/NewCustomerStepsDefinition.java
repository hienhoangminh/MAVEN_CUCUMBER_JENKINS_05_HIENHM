package stepDefinitions;

import org.openqa.selenium.WebDriver;

import commons.AbstractTest;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberOptions.Hooks;
import pageObjects.NewCustomerPageObject;
import pageObjects.PageFactoryManager;

public class NewCustomerStepsDefinition {

	WebDriver driver;
	private NewCustomerPageObject newCustomerPage;
	private AbstractTest abstractTest;
	static String customerId;


	public NewCustomerStepsDefinition() {
		driver = Hooks.openBrowser();
		newCustomerPage = PageFactoryManager.openNewCustomerPage(driver);
		abstractTest = new AbstractTest();
	}
	
	@When("^I can get customerId info$")
	public void iCanGetCustomerIdInfo() {
		customerId = newCustomerPage.getCustomerId();
		System.out.println("CustomerId is : " + customerId);
	}
}
