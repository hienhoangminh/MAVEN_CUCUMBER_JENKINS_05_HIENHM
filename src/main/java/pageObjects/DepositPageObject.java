package pageObjects;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import commons.AbstractPage;
import pageUI.AbstractPageUI;

public class DepositPageObject extends AbstractPage{

	WebDriver driver;

	public DepositPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputAccountNo(String accountNo) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_LOCATOR, "input", "accountno");
		sendKeyToElement(driver, accountNo, true, AbstractPageUI.DYNAMIC_LOCATOR, "input", "accountno");

	}

	public void inputAmount(String amount) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_LOCATOR, "input", "ammount");
		sendKeyToElement(driver, amount, true, AbstractPageUI.DYNAMIC_LOCATOR, "input", "ammount");
	}

	public void inputDescription(String description) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_LOCATOR, "input", "desc");
		sendKeyToElement(driver, description, true, AbstractPageUI.DYNAMIC_LOCATOR, "input", "desc");

	}

	public void submitDepositRequest() {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_LOCATOR, "input", "AccSubmit");
		clickOnElement(driver, AbstractPageUI.DYNAMIC_LOCATOR, "input", "AccSubmit");
	}

	public void verifyDepositSucessfulMessage(String accountId) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_TABLE_ELEMENT, "deposit", "/p[@class='heading3']");
		Assert.assertEquals(
				getTextElement(driver, AbstractPageUI.DYNAMIC_TABLE_ELEMENT, "deposit", "/p[@class='heading3']"), "Transaction details of Deposit for Account " + accountId);
	}
	
	public void verifyUpdatedBalance(String newExpectedBalance) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_TABLE_ELEMENT, "deposit", "/td[text()='Current Balance']/following-sibling::td");
		Assert.assertEquals(
				getTextElement(driver, AbstractPageUI.DYNAMIC_TABLE_ELEMENT, "deposit", "/td[text()='Current Balance']/following-sibling::td"), newExpectedBalance);

	}

}
