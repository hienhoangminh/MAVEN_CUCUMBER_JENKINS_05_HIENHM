package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import commons.AbstractPage;
import pageUI.AbstractPageUI;

public class NewCustomerPageObject extends AbstractPage {

	WebDriver driver;
	JavascriptExecutor  js;

	public NewCustomerPageObject(WebDriver driver) {
		this.driver = driver;
		js = (JavascriptExecutor) driver;
	}

	public void inputCustomerName(String value) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_LOCATOR, "input", "name");
		sendKeyToElement(driver, value, true, AbstractPageUI.DYNAMIC_LOCATOR, "input", "name");
	}

	public void inputCustomerDOB(String value) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_LOCATOR, "input", "dob");
		sendKeyToDynamicElement(driver, value, "dob");
	}

	public void inputCustomerAddress(String value) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_LOCATOR, "textarea", "addr");
		sendKeyToElement(driver, value, true, AbstractPageUI.DYNAMIC_LOCATOR, "textarea", "addr");
	}

	public void inputCity(String value) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_LOCATOR, "input", "city");
		sendKeyToElement(driver, value, true, AbstractPageUI.DYNAMIC_LOCATOR, "input", "city");
	}

	public void inputState(String value) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_LOCATOR, "input", "state");
		sendKeyToElement(driver, value, true, AbstractPageUI.DYNAMIC_LOCATOR, "input", "state");
	}

	public void inputPIN(String value) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_LOCATOR, "input", "pinno");
		sendKeyToElement(driver, value, true, AbstractPageUI.DYNAMIC_LOCATOR, "input", "pinno");
	}

	public void inputTelephoneNumber(String value) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_LOCATOR, "input", "telephoneno");
		sendKeyToElement(driver, value, true, AbstractPageUI.DYNAMIC_LOCATOR, "input", "telephoneno");
	}

	public void inputEmail(String value) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_LOCATOR, "input", "emailid");
		sendKeyToElement(driver, value, true, AbstractPageUI.DYNAMIC_LOCATOR, "input", "emailid");

	}

	public void inputPassword(String value) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_LOCATOR, "input", "password");
		sendKeyToElement(driver, value, true, AbstractPageUI.DYNAMIC_LOCATOR, "input", "password");
	}

	public void fillNewCustomerForm(String... values) {
		inputCustomerName((String) values[0]);
		inputCustomerDOB((String) values[1]);
		inputCustomerAddress((String) values[2]);
		inputCity((String) values[3]);
		inputState((String) values[4]);
		inputPIN((String) values[5]);
		inputTelephoneNumber((String) values[6]);
		inputEmail((String) values[7]);
		inputPassword((String) values[8]);

	}

	public void submitForm() {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_LOCATOR, "input", "sub");
		clickOnDynamicElementByJS(driver, "sub");
	}

	public void verifySucessfulRegisterMessage() {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_TABLE_ELEMENT,"regmsg","/p[@class='heading3']");
		Assert.assertTrue(isControlDisplayed(driver, AbstractPageUI.DYNAMIC_TABLE_ELEMENT,"regmsg",
				"/p[@class='heading3'][text()='Customer Registered Successfully!!!']"));
	}

	public String getCustomerId() {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_TABLE_ELEMENT,"regmsg",
				"/td[text()='Customer ID']/following-sibling::td");
		return getTextElement(driver, AbstractPageUI.DYNAMIC_TABLE_ELEMENT,"regmsg",
				"/td[text()='Customer ID']/following-sibling::td");
	}

}
