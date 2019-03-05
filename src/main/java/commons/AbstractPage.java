package commons;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.BalanceEnquiryPageObject;
import pageObjects.DeleteAccountPageObject;
import pageObjects.DeleteCustomerPageObject;
import pageObjects.DepositPageObject;
import pageObjects.EditCustomerPageObject;
import pageObjects.FundTransferPageObject;
import pageObjects.HomePageObject;
import pageObjects.NewAccountPageObject;
import pageObjects.NewCustomerPageObject;
import pageObjects.PageFactoryManager;
import pageObjects.WithdrawPageObject;
import pageUI.AbstractPageUI;

/**
 * Common actions : Selenium API
 * 
 * @author hoanghien
 *
 */

public class AbstractPage {

	public void openAnyUrl(WebDriver driver, String url) {
		driver.get(url);

	}

	public String getPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getPageCurrentUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public void backToPreviousPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public void clickOnElement(WebDriver driver, String locator) {
		WebElement el = driver.findElement(By.xpath(locator));
		el.click();
	}

	public void clickOnElement(WebDriver driver, String locator, String... attrValues) {
		locator = String.format(locator, (Object[]) attrValues);
		WebElement el = driver.findElement(By.xpath(locator));
		el.click();
	}

	// Normal method
	public String getTextElement(WebDriver driver, String locator) {
		WebElement el = driver.findElement(By.xpath(locator));
		return el.getText();
	}

	// Method with dynamic locator
	public String getTextElement(WebDriver driver, String locator, String... attrValues) {
		locator = String.format(locator, (Object[]) attrValues);
		WebElement el = driver.findElement(By.xpath(locator));
		return el.getText();
	}

	public void sendKeyToElement(WebDriver driver, String locator, String value) {
		WebElement el = driver.findElement(By.xpath(locator));
		el.clear();
		el.sendKeys(value);
	}

	public void sendKeyToElement(WebDriver driver, String value, boolean isClearable, String locator,
			String... attrValues) {
		locator = String.format(locator, (Object[]) attrValues);
		WebElement el = driver.findElement(By.xpath(locator));
		if (isClearable == true) {
			el.clear();
		}
		el.sendKeys(value);
	}

	public void selectItemInDropdown(WebDriver driver, String locator, String item) {
		Select select = new Select(driver.findElement(By.xpath(locator)));
		select.selectByVisibleText(item);
	}

	public void selectItemInDynamicDropdown(WebDriver driver, String item,String... attrValues) {
		String locator = String.format(AbstractPageUI.DYNAMIC_DROPDOWN, (Object[]) attrValues);
		Select select = new Select(driver.findElement(By.xpath(locator)));
		select.selectByVisibleText(item);
	}

	public void selectCustomDropdownList(WebDriver driver, String dropdown, String listItems, String valueItem) {
		// Click on element
		WebElement dropdownEl = driver.findElement(By.xpath(dropdown));

		WebDriverWait wait = new WebDriverWait(driver, 30);
		((JavascriptExecutor) driver).executeScript("arugments[0].scrollIntoView(true);", dropdownEl);
		dropdownEl.click();

		List<WebElement> allItems = driver.findElements(By.xpath(listItems));
		wait.until(ExpectedConditions.visibilityOfAllElements(allItems));
		// Loop through the list of retrieved element
		for (WebElement item : allItems) {
			if (item.getText().trim().equalsIgnoreCase(valueItem)) {
				((JavascriptExecutor) driver).executeScript("arugments[0].scrollIntoView(true);", item);
				item.isDisplayed();
				item.click();
				break;
			}
		}
	}

	public String getFirstItemSelected(WebDriver driver, String locator) {
		Select select = new Select(driver.findElement(By.xpath(locator)));
		return select.getFirstSelectedOption().getText();
	}

	public String getAttributeValue(WebDriver driver, String locator, String attributeName) {
		WebElement el = driver.findElement(By.xpath(locator));
		return el.getAttribute(attributeName);
	}

	public int getSizeElement(WebDriver driver, String locator) {
		List<WebElement> els = driver.findElements(By.xpath(locator));
		return els.size();
	}

	public void checkToCheckBox(WebDriver driver, String locator) {
		WebElement el = driver.findElement(By.xpath(locator));
		if (!el.isSelected()) {
			el.click();
		}
	}

	public void uncheckToCheckBox(WebDriver driver, String locator) {
		WebElement el = driver.findElement(By.xpath(locator));
		if (el.isSelected()) {
			el.click();
		}
	}

	public boolean isControlDisplayed(WebDriver driver, String locator) {
		WebElement el = driver.findElement(By.xpath(locator));
		return el.isDisplayed();
	}

	public boolean isControlDisplayed(WebDriver driver, String locator, String... values) {
		locator = String.format(locator, (Object[]) values);
		WebElement el = driver.findElement(By.xpath(locator));
		return el.isDisplayed();
	}

	public boolean isControlEnabled(WebDriver driver, String locator) {
		WebElement el = driver.findElement(By.xpath(locator));
		return el.isEnabled();

	}

	public boolean isControlSelected(WebDriver driver, String locator) {
		WebElement el = driver.findElement(By.xpath(locator));
		return el.isSelected();

	}

	public boolean isControlUndisplayed(WebDriver driver, String locator) {
		overrideGlobalTimeout(driver, 10);
		List<WebElement> elements = driver.findElements(By.xpath(locator));
		if (elements.isEmpty()) {
			overrideGlobalTimeout(driver, 10);
			return true;
		} else {
			overrideGlobalTimeout(driver, 10);
			return false;
		}
	}

	public void overrideGlobalTimeout(WebDriver driver, long timeOut) {
		driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
	}

	public void acceptToAlert(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	
	public void acceptToAlertAgain(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}

	public void cancelToAlert(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}

	public void sendKeyToAlert(WebDriver driver, String value) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(value);
	}

	public String getTextOfAlert(WebDriver driver) {
		Alert alert = driver.switchTo().alert();
		return alert.getText();
	}

	public void hoverToElement(WebDriver driver, String locator) {
		WebElement el = driver.findElement(By.xpath(locator));
		Actions action = new Actions(driver);
		action.moveToElement(el).build().perform();
	}

	public void uploadFile(WebDriver driver, String fileName) {
		String proDir = System.getProperty("user.dir");
		String file = proDir + "\\images" + fileName;
		WebElement el = driver.findElement(By.xpath("//input[@type='file']"));
		el.sendKeys(file);
	}

	public void waitForControlVisible(WebDriver driver, String locator) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(locator))));
	}

	public void waitForControlVisible(WebDriver driver, String locator, String... values) {
		locator = String.format(locator, (Object[]) values);
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath(locator))));
	}

	public void waitForControlNotVisible(WebDriver driver, long timeout, String locator) {
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(locator)));
	}
	
	public void waitForControlClickable(WebDriver driver,String locator) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath(locator))));
	}

	public void waitForAlertPresence(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.alertIsPresent());
	}

	public String randomEmail() {
		int rand = (int) System.currentTimeMillis();
		return "online" + rand + "@gmail.com";
	}

	public HomePageObject openHomePage(WebDriver driver) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, "Manager");
		clickOnElement(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, "Manager");
		return PageFactoryManager.openHomePage(driver);
	}

	public DeleteAccountPageObject openDeleteAccountPage(WebDriver driver) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, "Delete Account");
		clickOnElement(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, "Delete Account");
		return PageFactoryManager.openDeleteAccountPage(driver);
	}

	public EditCustomerPageObject openEditCustomerPage(WebDriver driver) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, "Edit Customer");
		clickOnElement(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, "Edit Customer");
		return PageFactoryManager.openEditCustomerPage(driver);
	}

	public NewCustomerPageObject openNewCustomerPage(WebDriver driver) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, "New Customer");
		clickOnElement(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, "New Customer");
		return PageFactoryManager.openNewCustomerPage(driver);
	}

	public WithdrawPageObject openWithDrawPage(WebDriver driver) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, "Withdrawal");
		clickOnElement(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, "Withdrawal");
		return PageFactoryManager.openWithDrawPage(driver);
	}

	public NewAccountPageObject openNewAccountPage(WebDriver driver) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, "New Account");
		clickOnElement(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, "New Account");
		return PageFactoryManager.openNewAccountPage(driver);
	}

	public DepositPageObject openDepositPage(WebDriver driver) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, "Deposit");
		clickOnElement(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, "Deposit");
		return PageFactoryManager.openDepositPage(driver);
	}

	public BalanceEnquiryPageObject openBalanceEnquiryPage(WebDriver driver) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, "Balance Enquiry");
		clickOnElement(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, "Balance Enquiry");
		return PageFactoryManager.openBalanceEnquiryPage(driver);
	}

	public FundTransferPageObject openFundTransferPage(WebDriver driver) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, "Fund Transfer");
		clickOnElement(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, "Fund Transfer");
		return PageFactoryManager.openNewFundTransferPage(driver);
	}

	public DeleteCustomerPageObject openDeleteCustomerPage(WebDriver driver) {
		waitForControlVisible(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, "Delete Customer");
		clickOnElement(driver, AbstractPageUI.DYNAMIC_PAGE_LINK, "Delete Customer");
		return PageFactoryManager.openDeleteCustomerPage(driver);
	}

	// Dynamic locator - Dynamic page object
	public void clickOnDynamicLink(WebDriver driver, String... attrValues) {
		String locator = String.format(AbstractPageUI.DYNAMIC_PAGE_LINK, (Object[]) attrValues);
		waitForControlVisible(driver, locator);
		clickOnElement(driver, locator);
	}

	public void clickOnDynamicElement(WebDriver driver, String... attrValues) {
		String locator = String.format(AbstractPageUI.DYNAMIC_INPUT, (Object[]) attrValues);
		waitForControlClickable(driver, locator);
		clickOnElement(driver, locator);
	}
	
	public void clickOnDynamicElementByJS(WebDriver driver, String... attrValues) {
		String locator = String.format(AbstractPageUI.DYNAMIC_INPUT, (Object[]) attrValues);
		waitForControlClickable(driver, locator);
		WebElement el = driver.findElement(By.xpath(locator));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", el);
	}

	public void sendKeyToElement(WebDriver driver, String locator,String inputtedValue, String... attrValues) {
		locator = String.format(locator, (Object[]) attrValues);
		waitForControlVisible(driver, locator);
		WebElement el = driver.findElement(By.xpath(locator));
		el.clear();
		el.sendKeys(inputtedValue);
	}

	public void sendKeyToDynamicElement(WebDriver driver, boolean isInput, boolean isClearable, String value,
			String attrValue) {
		String locator = "";
		if (isInput) {
			locator = String.format(AbstractPageUI.DYNAMIC_LOCATOR, "input", attrValue);
		} else {
			locator = String.format(AbstractPageUI.DYNAMIC_LOCATOR, "textarea", attrValue);
		}
		waitForControlVisible(driver, locator);
		WebElement el = driver.findElement(By.xpath(locator));
		if (isClearable) {
			el.clear();
		}
		el.sendKeys(value);

	}

	public void sendKeyToDynamicElement(WebDriver driver, String value, String attrValue) {
		String locator = String.format(AbstractPageUI.DYNAMIC_LOCATOR, "input", attrValue);
		waitForControlVisible(driver, locator);
		WebElement el = driver.findElement(By.xpath(locator));
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('type', 'text');", el);
		el.clear();
		el.sendKeys(value);
		;

	}

	public String getTextOfElement(WebDriver driver, String... attrValues) {
		String locator = String.format(AbstractPageUI.DYNAMIC_FOLLOWING_TD, (Object[]) attrValues);
		waitForControlVisible(driver, locator);
		WebElement el = driver.findElement(By.xpath(locator));
		return el.getText();
	}

	public boolean verifyElementUndisplayed(WebDriver driver, String... attrValues) {
		String locator = String.format(AbstractPageUI.DYNAMIC_MESSAGE_TEXT, (Object[]) attrValues);
		return isControlUndisplayed(driver, locator);
	}

	public boolean verifyMessageDisplayed(WebDriver driver, String... values) {
		String locator = String.format(AbstractPageUI.DYNAMIC_MESSAGE_TEXT, (Object[]) values);
		waitForControlVisible(driver, locator);
		return isControlDisplayed(driver, locator);
	}

	public boolean verifyTitleDisplayed(WebDriver driver, String... values) {
		String locator = String.format(AbstractPageUI.DYNAMIC_TITLE, (Object[]) values);
		waitForControlVisible(driver, locator);
		return isControlDisplayed(driver, locator);
	}

	public boolean verifyTextEquals(WebDriver driver, String text, boolean isTitle, String... values) {
		String locator = "";
		if (isTitle) {
			locator = String.format(AbstractPageUI.DYNAMIC_TITLE, (Object[]) values);
		} else {
			locator = String.format(AbstractPageUI.DYNAMIC_FOLLOWING_TD, (Object[]) values);
		}
		waitForControlVisible(driver, locator);
		return getTextElement(driver, locator).equals(text);
	}

	public boolean verifyTextAlertEquals(WebDriver driver, String text) {
		waitForAlertPresence(driver);
		return getTextOfAlert(driver).equals(text);
	}

	public void selectValueFromDynamicElement(WebDriver driver, String value, String attrValues) {
		String locator = String.format(AbstractPageUI.DYNAMIC_LOCATOR, "select", attrValues);
		waitForControlVisible(driver, locator);
		selectItemInDropdown(driver, locator, value);
	}

	public AbstractPage openDynamicLink(WebDriver driver, String name) {
		String locator = String.format(AbstractPageUI.DYNAMIC_PAGE_LINK, name);
		waitForControlVisible(driver, locator);
		clickOnElement(driver, locator);

		switch (name) {
		case "Manager":
			return PageFactoryManager.openHomePage(driver);
		case "New Customer":
			return PageFactoryManager.openNewCustomerPage(driver);
		case "Edit Customer":
			return PageFactoryManager.openEditCustomerPage(driver);
		case "Delete Customer":
			return PageFactoryManager.openDeleteCustomerPage(driver);
		case "New Account":
			return PageFactoryManager.openNewAccountPage(driver);
		case "Edit Account":
			return PageFactoryManager.openEditAccountPage(driver);
		case "Delete Account":
			return PageFactoryManager.openDeleteAccountPage(driver);
		case "Deposit":
			return PageFactoryManager.openDepositPage(driver);
		case "Withdrawal":
			return PageFactoryManager.openWithDrawPage(driver);
		case "Fund Transfer":
			return PageFactoryManager.openNewFundTransferPage(driver);
		case "Change Password":
			return PageFactoryManager.openChangePasswordPage(driver);
		case "Balance Enquiry":
			return PageFactoryManager.openBalanceEnquiryPage(driver);
		case "Mini Statement":
			return PageFactoryManager.openMiniStatementPage(driver);
		case "Customised Statement":
			return PageFactoryManager.openCustomisedStatementPage(driver);
		case "here":
			return PageFactoryManager.openRegisterPage(driver);
		default:
			return PageFactoryManager.openHomePage(driver);
		}

	}
}
