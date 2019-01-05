package pageObjects;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import commons.AbstractPage;
import pageUI.AbstractPageUI;

public class WithdrawPageObject extends AbstractPage{
	
	WebDriver driver;

	public WithdrawPageObject(WebDriver driver) {
        this.driver = driver;
	}

	public void inputAccountNo(String accountId) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_LOCATOR, "input", "accountno");
		sendKeyToElement(driver, accountId, true, AbstractPageUI.DYNAMIC_LOCATOR, "input", "accountno");	
	}

	public void inputAmount(String amount) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_LOCATOR, "input", "ammount");
		sendKeyToElement(driver, amount, true, AbstractPageUI.DYNAMIC_LOCATOR, "input", "ammount");
	}

	public void inputDescription(String description) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_LOCATOR, "input", "desc");
		sendKeyToElement(driver, description, true, AbstractPageUI.DYNAMIC_LOCATOR, "input", "desc");
		
	}

	public void submitWithdrawRequest() {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_LOCATOR, "input", "AccSubmit");
		clickOnElement(driver, AbstractPageUI.DYNAMIC_LOCATOR, "input", "AccSubmit");
	}

	public void verifyWithdrawSucessfulMessage(String accountId) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_TABLE_ELEMENT, "withdraw", "/p[@class='heading3']");
		Assert.assertEquals(
				getTextElement(driver, AbstractPageUI.DYNAMIC_TABLE_ELEMENT, "withdraw", "/p[@class='heading3']"), "Transaction details of Withdrawal for Account " + accountId);

	}

	public void verifyUpdatedBalance(String newExpectedBalance) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_TABLE_ELEMENT, "withdraw", "/td[text()='Current Balance']/following-sibling::td");
		Assert.assertEquals(
				getTextElement(driver, AbstractPageUI.DYNAMIC_TABLE_ELEMENT, "withdraw", "/td[text()='Current Balance']/following-sibling::td"), newExpectedBalance);

	}

	

}
