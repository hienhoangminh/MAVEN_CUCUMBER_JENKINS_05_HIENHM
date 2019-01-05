package pageObjects;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import commons.AbstractPage;
import pageUI.AbstractPageUI;

public class DeleteCustomerPageObject extends AbstractPage{

	WebDriver driver;
	
	public DeleteCustomerPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void inputCustomerId(String value) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_LOCATOR, "input", "cusid");
		sendKeyToElement(driver, value,true, AbstractPageUI.DYNAMIC_LOCATOR, "input", "cusid");
	}

	public void searchForCustomerId() {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_LOCATOR, "input", "AccSubmit");
		clickOnElement(driver, AbstractPageUI.DYNAMIC_LOCATOR, "input", "AccSubmit");
	}

	public void confirmDeleteCustomer() {
		waitForAlertPresence(driver);
		acceptToAlert(driver);
	}

	public void verifyDeleteCustomerMessage(String expectedMsg) {
		waitForAlertPresence(driver);
		Assert.assertEquals(getTextOfAlert(driver), expectedMsg);
	}

	
}
