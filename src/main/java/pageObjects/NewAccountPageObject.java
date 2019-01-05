package pageObjects;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import commons.AbstractPage;
import pageUI.AbstractPageUI;

public class NewAccountPageObject extends AbstractPage{

	WebDriver driver;

	public NewAccountPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputCustomerId(String cusId) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_LOCATOR, "input", "cusid");
		sendKeyToElement(driver, cusId, true, AbstractPageUI.DYNAMIC_LOCATOR, "input", "cusid");

	}

	public void selectAccountType(String option) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_LOCATOR, "select", "selaccount");
        selectItemInDropdown(driver, option, "selaccount");

	}

	public void inputInitialAmount(String amount) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_LOCATOR, "input", "inideposit");
		sendKeyToElement(driver, amount, true, AbstractPageUI.DYNAMIC_LOCATOR, "input", "inideposit");

	}

	public void submitCreateAccountRequest() {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_LOCATOR, "input", "button2");
        clickOnElement(driver,AbstractPageUI.DYNAMIC_LOCATOR,"input", "button2");
	}

	public void verifyAccountCreatedMessage() {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_TABLE_ELEMENT,"Accmsg", "/p[@class='heading3']");
		Assert.assertTrue(isControlDisplayed(driver, AbstractPageUI.DYNAMIC_TABLE_ELEMENT,"Accmsg", "/p[@class='heading3'][text()='Account Generated Successfully!!!']"));
	}

	public void verifyCurrentAmountBalance(String expectedAmount) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_TABLE_ELEMENT,"Accmsg", "/td[text()='Current Amount']/following-sibling::td");
		Assert.assertEquals(
				getTextElement(driver, AbstractPageUI.DYNAMIC_TABLE_ELEMENT,"Accmsg", "/td[text()='Current Amount']/following-sibling::td"),expectedAmount);
	}
	
	public String getAccountId() {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_TABLE_ELEMENT,"Accmsg",
				"/td[text()='Account ID']/following-sibling::td");
		return getTextElement(driver, AbstractPageUI.DYNAMIC_TABLE_ELEMENT,"Accmsg",
				"/td[text()='Account ID']/following-sibling::td");
	}

}
