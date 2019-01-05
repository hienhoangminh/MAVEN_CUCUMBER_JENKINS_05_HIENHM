package stepDefinitions;

import org.openqa.selenium.WebDriver;

import commons.AbstractTest;
import cucumber.api.java.en.Then;
import cucumberOptions.Hooks;
import pageObjects.HomePageObject;
import pageObjects.PageFactoryManager;

public class HomepageStepsDefinition {

	private WebDriver driver;
	private HomePageObject homePage;
	AbstractTest abstractTest;
	
	public HomepageStepsDefinition() {
		driver = Hooks.openBrowser();
		homePage = PageFactoryManager.openHomePage(driver);
		abstractTest = new AbstractTest();
	}
	
	@Then("^verify home page displayed with message \"([^\"]*)\"$")
	public void verifyHomePageDisplayedWithMessage(String message) {
		abstractTest.verifyTrue(homePage.isHomepPageDisplayed(message));
	}
}
