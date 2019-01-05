package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import commons.AbstractPage;
import pageUI.AbstractPageUI;

public class FundTransferPageObject extends AbstractPage{


	WebDriver driver;
	WebDriverWait wait;
	
	public FundTransferPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputPayerAccount(String payerAccountNo) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_LOCATOR, "input", "payersaccount");
		sendKeyToElement(driver, payerAccountNo, true, AbstractPageUI.DYNAMIC_LOCATOR, "input", "payersaccount");
	}
	
	public void inputPayeesAccount(String payeeAccountNo) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_LOCATOR, "input", "payeeaccount");
		sendKeyToElement(driver, payeeAccountNo, true, AbstractPageUI.DYNAMIC_LOCATOR, "input", "payeeaccount");
	}
	
	public void inputAmount(String amount) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_LOCATOR, "input", "ammount");
		sendKeyToElement(driver, amount, true, AbstractPageUI.DYNAMIC_LOCATOR, "input", "ammount");
	}
	
	public void inputDescription(String description) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_LOCATOR, "input", "desc");
		sendKeyToElement(driver, description, true, AbstractPageUI.DYNAMIC_LOCATOR, "input", "desc");
	}
	
	public void submitFundTransferRequest() {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_LOCATOR, "input", "AccSubmit");
        clickOnElement(driver,AbstractPageUI.DYNAMIC_LOCATOR,"input", "AccSubmit");
	}
	

	public void verifyFundSucessfulMessage(String fromAccountNo,String toAccountNo) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_ELEMENT_WITH_TEXT,"p", "Fund Transfer Details");
		Assert.assertTrue(isControlDisplayed(driver, AbstractPageUI.DYNAMIC_ELEMENT_WITH_TEXT,"p", "Fund Transfer Details"));
		Assert.assertEquals(getTextElement(driver, AbstractPageUI.DYNAMIC_FOLLOWING_LOCATOR,"td[text()='From Account Number']", "td"),fromAccountNo);
		Assert.assertEquals(getTextElement(driver, AbstractPageUI.DYNAMIC_FOLLOWING_LOCATOR,"td[text()='To Account Number']", "td"),toAccountNo);

	}

	public void verifyTransferAmount(String expectedAmount) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_FOLLOWING_LOCATOR,"td[text()='Amount']", "td");
		Assert.assertEquals(
				getTextElement(driver, AbstractPageUI.DYNAMIC_FOLLOWING_LOCATOR,"td[text()='Amount']", "td"),expectedAmount);
	}}
