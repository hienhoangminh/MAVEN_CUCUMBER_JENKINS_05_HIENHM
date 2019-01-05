package pageObjects;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import commons.AbstractPage;
import pageUI.AbstractPageUI;

public class DeleteAccountPageObject extends AbstractPage {

	WebDriver driver;

	public DeleteAccountPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputAccountNo(String accountId) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_LOCATOR, "input", "accountno");
		sendKeyToElement(driver, accountId, true, AbstractPageUI.DYNAMIC_LOCATOR, "input", "accountno");
	}

	public void searchForAccountNo() {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_LOCATOR, "input", "AccSubmit");
		clickOnElement(driver, AbstractPageUI.DYNAMIC_LOCATOR, "input", "AccSubmit");
	}

	public void confirmDeleteAccount() {
		waitForAlertPresence(driver);
		acceptToAlert(driver);
	}

	public void verifyDeleteAccountMessage(String expectedMsg) {
		waitForAlertPresence(driver);
		Assert.assertEquals(getTextOfAlert(driver), expectedMsg);
	}
	

}
