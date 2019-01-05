package stepDefinitions;

import org.openqa.selenium.WebDriver;

import commons.AbstractTest;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberOptions.Hooks;
import pageObjects.AbstractPageObject;
import pageObjects.PageFactoryManager;
import pageUI.AbstractPageUI;

public class AbstractTestDefinitions {

	WebDriver driver;
	private AbstractPageObject abstractPage;
	private AbstractTest abstractTest;

	public AbstractTestDefinitions() {
		driver = Hooks.openBrowser();
		abstractPage = PageFactoryManager.openAbstractPage(driver);
		abstractTest = new AbstractTest();
	}

	@When("^I input to \"([^\"]*)\" textbox with data \"([^\"]*)\"$")
	public void iInputToTextboxWithData(String textBoxName, String value) {
		if(textBoxName.equalsIgnoreCase("dob")) {
			abstractPage.sendKeyToDynamicElement(driver, value, textBoxName);
		}else {
		    abstractPage.inputToDynamicTextBox(textBoxName, value);
		}
	}

	@When("^I input to \"([^\"*])\" textbox with random data \"([^\"*])\"$")
	public void iInputToDynamicTextBoxWithDynamicRandomData(String textBoxId, String value) {
		value = value + " " + abstractTest.randomNum();
		abstractPage.inputToDynamicTextBox(textBoxId, value);
	}

	@When("^I input to \"([^\"]*)\" textbox with \"([^\"]*)\" data \"([^\"]*)\"$")
	public void iInputToTextboxWithData(String textBoxId, String statusRandom, String value) {
		if (statusRandom.equals("1")) {
			value = value + " " + abstractTest.randomNum();
		} else if (statusRandom.equals("2")) {
			value = value + "_" + abstractTest.randomNum() + "@gmail.com";

		}
		abstractPage.inputToDynamicTextBox(textBoxId, value);
	}

	@When("^I input to \"([^\"]*)\" textarea with data \"([^\"]*)\"$")
	public void iInputToTextareaWithData(String textAreaId, String value) {
		abstractPage.inputToDynamicArea(textAreaId, value);
	}

	@When("^I select item in \"([^\"]*)\" dropdown list with data \"([^\"]*)\"$")
	public void iSelectItemInDropdownListWithData(String dropdowName, String itemValue) {
		abstractPage.selectItemInDynamicDropdown(driver, itemValue, dropdowName);
	}

	@When("^I select \"([^\"*])\" radio button$")
	public void iSelectDynamicRadioButton(String radioButtonName) {
		abstractPage.clickToDynamicElement(radioButtonName);
	}

	@When("^I open \"([^\"]*)\" page$")
	public void iOpenDynamicPage(String pageName) {
		abstractPage.clickToDynamicPageLink(pageName);
	}

	@When("^I click on \"([^\"]*)\" button$")
	public void iClickOnButton(String buttonName) {
		abstractPage.clickToDynamicElement(buttonName);
	}

	@Then("^I can get \"([^\"]*)\" value$")
	public String getValueOfElement(String elementName) {
		return abstractPage.getTextElement(driver, AbstractPageUI.DYNAMIC_FOLLOWING_TD, elementName);
	}

	@When("^I input to (edit_customer|new_account|deposit|withdrawal|transfer|balance_enquiry|fund_transfer|del_acc|del_user) \"([^\"]*)\" textbox$")
	public void iInputValueToTextBoxWithAccountIdInfo(String step, String textboxName) {
		switch (step) {
		case "edit_customer":
		case "new_account":
		case "del_user":	
			abstractPage.sendKeyToElement(driver, AbstractPageUI.DYNAMIC_INPUT, NewCustomerStepsDefinition.customerId,
					textboxName);
			break;
		case "deposit":
		case "withdrawal":
		case "transfer":
		case "balance_enquiry":
		case "fund_transfer":
		case "del_acc":	
			abstractPage.sendKeyToElement(driver, AbstractPageUI.DYNAMIC_INPUT, NewAccountStepsDefinition.accoutId,
					textboxName);
			break;
		default:
			break;
		}

	}
	
	@When("^I click (first|second) times to accept button on (del_acc|del_user) alert$")
	public void iClickToAcceptAlertButton(String no,String page) {
		if(no.equalsIgnoreCase("first")  && (page.equalsIgnoreCase("del_acc") || page.equalsIgnoreCase("del_user"))) {
		    abstractPage.acceptToAlert(driver);
		}
		if(no.equalsIgnoreCase("second")  && (page.equalsIgnoreCase("del_acc") || page.equalsIgnoreCase("del_user"))) {
		    abstractPage.acceptToAlert(driver);
		}
	}
	
	@When("^I click again to accept button on (del_acc|del_user) alert$")
	public void iClickAgainToAcceptAlertButton(String page) {
		if(page.equalsIgnoreCase("del_acc") || page.equalsIgnoreCase("del_user")) {
		    abstractPage.acceptToAlertAgain(driver);
		}
	}

	// Verify
	@Then("^Verify message \"([^\"]*)\" is displayed$")
	public void verifyMessageIsDisplayed(String message) {
		abstractTest.verifyTrue(abstractPage.isMessageDisplayed(message));
	}

	@Then("^Verify message \"([^\"]*)\" is displayed with \"([^\"]*)\" data AccountId info$")
	public void verifyMessageIsDisplayedWithCorrectAccountId(String message, String status) {
		if (status.equals("1")) {
			message = message + " " + NewAccountStepsDefinition.accoutId;
		}
		abstractTest.verifyTrue(abstractPage.isMessageDisplayed(message));
	}

	@Then("^Verify actual (new_account|deposit|withdrawal|transfer) value is the same as expected value \"([^\"]*)\"$")
	public void verifyActualValueIsTheSameAsExpectedValue(String step,String expectedResult){
		switch(step) {
		case "new_account":
			abstractTest.verifyEquals(abstractPage.getTextElement(driver, AbstractPageUI.DYNAMIC_FOLLOWING_TD, "Current Amount"), expectedResult);
		  break;
		case "deposit":
			abstractTest.verifyEquals(abstractPage.getTextElement(driver, AbstractPageUI.DYNAMIC_FOLLOWING_TD, "Current Balance"), expectedResult);
		  break;
		case "transfer" :
			abstractTest.verifyEquals(abstractPage.getTextElement(driver, AbstractPageUI.DYNAMIC_FOLLOWING_TD, "Amount"), expectedResult);
		    break;
		default:
			break;    
		}
	}
	
	@Then("^Verify alert message \"([^\"]*)\" is displayed$")
	public void verifyAlertMessageIsDisplayed(String message){
		abstractTest.verifyEquals(abstractPage.getTextOfAlert(driver), message);
	}


}
