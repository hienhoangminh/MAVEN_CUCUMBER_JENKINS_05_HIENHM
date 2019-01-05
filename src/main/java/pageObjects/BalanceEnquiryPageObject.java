package pageObjects;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import commons.AbstractPage;
import pageUI.AbstractPageUI;

public class BalanceEnquiryPageObject extends AbstractPage {

	WebDriver driver;

	public BalanceEnquiryPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public void inputAccountNo(String accountno) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_LOCATOR, "input", "accountno");
		sendKeyToElement(driver, accountno, true, AbstractPageUI.DYNAMIC_LOCATOR, "input", "accountno");

	}
	
	public void searchForAccountNo() {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_LOCATOR, "input", "AccSubmit");
        clickOnElement(driver,AbstractPageUI.DYNAMIC_LOCATOR,"input", "AccSubmit");

	}

	public void verifyBalanceInfo(String accountId) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_TABLE_ELEMENT, "balenquiry", "/p[@class='heading3']");
		Assert.assertEquals(
				getTextElement(driver, AbstractPageUI.DYNAMIC_TABLE_ELEMENT, "balenquiry", "/p[@class='heading3']"), "Balance Details for Account " + accountId);

	}

	public void verifyCurrentBalance(String newExpectedBalance) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_TABLE_ELEMENT, "balenquiry", "/td[text()='Balance']/following-sibling::td");
		Assert.assertEquals(
				getTextElement(driver, AbstractPageUI.DYNAMIC_TABLE_ELEMENT, "balenquiry", "/td[text()='Balance']/following-sibling::td"), newExpectedBalance);

	}
	
	
	
}
