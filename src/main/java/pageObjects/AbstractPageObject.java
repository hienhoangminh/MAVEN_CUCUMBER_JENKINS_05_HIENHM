package pageObjects;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUI.AbstractPageUI;

public class AbstractPageObject extends AbstractPage {

	WebDriver driver;

	public AbstractPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void inputToDynamicTextBox(String textBoxName, String value) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_INPUT, textBoxName);
		System.out.println("Tested " + textBoxName);
		sendKeyToElement(driver, AbstractPageUI.DYNAMIC_INPUT, value, textBoxName);
	}

	public void inputToDynamicArea(String textareaName, String value) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_AREA, textareaName);
		sendKeyToElement(driver, AbstractPageUI.DYNAMIC_AREA, value,textareaName);
	}

	public void selectDynamicDropdownList(String dropdownName, String value) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_DROPDOWN, dropdownName);
		selectItemInDropdown(driver, value, dropdownName);
	}

	public void clickToDynamicRadioButton(String radioButtonName) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_RADIO_BUTTON, radioButtonName);
		clickOnElement(driver, AbstractPageUI.DYNAMIC_RADIO_BUTTON, radioButtonName);
	}

	public void clickToDynamicElement(String buttonName) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_BUTTON, buttonName);
		clickOnElement(driver, AbstractPageUI.DYNAMIC_BUTTON, buttonName);
	}
	
	public boolean isMessageDisplayed(String message) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_MESSAGE, message);
		return isControlDisplayed(driver,AbstractPageUI.DYNAMIC_MESSAGE, message);

	}
	
	public void clickToDynamicPageLink(String pageName) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, pageName);
        clickOnElement(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, pageName);
        switch (pageName) {
		case "New Customer":
			PageFactoryManager.openNewCustomerPage(driver);
		case "Edit Customer":
			PageFactoryManager.openEditCustomerPage(driver);
		case "Delete Customer":
			PageFactoryManager.openDeleteCustomerPage(driver);
		case "New Account":
			PageFactoryManager.openNewAccountPage(driver);
		case "Edit Account":
			PageFactoryManager.openEditAccountPage(driver);
		case "Delete Account":
			PageFactoryManager.openDeleteAccountPage(driver);
		case "Deposit":
			PageFactoryManager.openDepositPage(driver);
		case "Withdrawal":
			PageFactoryManager.openWithDrawPage(driver);
		case "Fund Transfer":
			PageFactoryManager.openNewFundTransferPage(driver);
		case "Change Password":
			PageFactoryManager.openChangePasswordPage(driver);
		case "Balance Enquiry":
			PageFactoryManager.openBalanceEnquiryPage(driver);
		case "Mini Statement":
			PageFactoryManager.openMiniStatementPage(driver);
		case "Customised Statement":
			PageFactoryManager.openCustomisedStatementPage(driver);
		default:
			PageFactoryManager.openHomePage(driver);
		}
	}
	
}