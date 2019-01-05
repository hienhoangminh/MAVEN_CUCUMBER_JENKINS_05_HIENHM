package pageObjects;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import commons.AbstractPage;
import pageUI.AbstractPageUI;

public class EditCustomerPageObject extends AbstractPage{
	
	WebDriver driver;

	public EditCustomerPageObject(WebDriver driver) {
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
	
	public void verifyIfEditCustomerPage() {
        waitForControlVisible(driver, AbstractPageUI.DYNAMIC_LOCATOR, "/p[@class='heading3']");
		Assert.assertTrue(isControlDisplayed(driver, AbstractPageUI.DYNAMIC_LOCATOR, "/p[@class='heading3']"));
	}
	
	public void updateCustomerAddr(String value) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_LOCATOR, "textarea", "addr");
		sendKeyToElement(driver, value,true, AbstractPageUI.DYNAMIC_LOCATOR,  "textarea", "addr");
	}

	public void updateCustomerCity(String value) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_LOCATOR, "input", "city");
		sendKeyToElement(driver, value,true, AbstractPageUI.DYNAMIC_LOCATOR, "input", "city");
	}

	public void updateCustomerState(String value) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_LOCATOR, "input", "state");
		sendKeyToElement(driver, value,true, AbstractPageUI.DYNAMIC_LOCATOR, "input", "state");
	}

	public void updateCustomerPIN(String value) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_LOCATOR, "input", "pinno");
		sendKeyToElement(driver, value,true, AbstractPageUI.DYNAMIC_LOCATOR, "input", "pinno");
	}

	public void updateCustomerPhoneNo(String value) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_LOCATOR, "input", "telephoneno");
		sendKeyToElement(driver, value,true, AbstractPageUI.DYNAMIC_LOCATOR, "input", "telephoneno");
	}

	public void updateCustomerEmail(String value) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_LOCATOR, "input", "emailid");
		sendKeyToElement(driver,value,true, AbstractPageUI.DYNAMIC_LOCATOR, "input", "emailid");
	}


	public void updateCustomerForm(String... values) {
		updateCustomerAddr((String) values[0]);
		updateCustomerCity((String) values[1]);
		updateCustomerState((String) values[2]);
		updateCustomerPIN((String) values[3]);
		updateCustomerPhoneNo((String) values[4]);
		updateCustomerEmail((String) values[5]);
	}

	public void submitUpdatedForm() {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_LOCATOR, "input", "sub");
		clickOnElement(driver, AbstractPageUI.DYNAMIC_LOCATOR, "input", "sub");
	}

	public void verifySucessfulUpdateMessage() {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_TABLE_ELEMENT,"updatemsg", "/p[@class='heading3']");
		Assert.assertTrue(isControlDisplayed(driver, AbstractPageUI.DYNAMIC_TABLE_ELEMENT,"updatemsg", "/p[@class='heading3'][text()='Customer details updated Successfully!!!']"));
	}


}
