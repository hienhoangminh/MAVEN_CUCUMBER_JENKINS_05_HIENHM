package old;

import java.util.List;
import java.util.Map;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumberOptions.Hooks;

public class DemoSteps {

	WebDriver driver;
	JavascriptExecutor js;
	static String userId, userPass, loginUrl,customerId , email;

	public DemoSteps() {
		driver = Hooks.openBrowser();
		js = (JavascriptExecutor) driver;
	}

	@Given("^I get login page URL$")
	public void iOpenApplication() {
		loginUrl = driver.getCurrentUrl();
	}

	@When("^I click to here link$")
	public void iClickToHereLink() {
		driver.findElement(By.xpath("//a[text()='here']")).click();
	}
	
	@When("^I input to email textbox with data \"([^\"]*)\"$")
	public void iInputToEmailTextboxWithData(String email){
		driver.findElement(By.xpath("//input[@name='emailid']"))
		.sendKeys(email + System.currentTimeMillis() + "@gmail.com");
	}


	@When("^I click to Submit button$")
	public void iClickToSubmitButton() {
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
	}

	@Then("^I get UserID info$")
	public void iGetUserIDInfo() {
		userId = driver.findElement(By.xpath("//td[text()='User ID :']/following-sibling::td")).getText().trim();
	}

	@Then("^I get password info$")
	public void iGetPasswordInfo() {
		userPass = driver.findElement(By.xpath("//td[text()='Password :']/following-sibling::td")).getText().trim();
	}

	@When("^I open Login page again$")
	public void iOpenLoginPageAgain() {
		driver.get(loginUrl);
	}

	@Given("^I input to UserID textbox$")
	public void iInputToUserIDTextbox() {
		driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(userId);
	}

	@Given("^I input to Password textbox$")
	public void iInputToPasswordTextbox() {
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(userPass);

	}

	@Given("^I click to Login button at Login page$")
	public void iClickToLoginButtonAtLoginPage() {
		driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
	}

	@Then("^verify home page displayed with message \"([^\"]*)\"$")
	public void verifyHomePageDisplayedWithMessage(String message) {
		driver.findElement(By.xpath("//marquee[text()=\"" + message + "\"]")).isDisplayed();
	}

	@Given("^I click to New Customer link$")
	public void iClickToNewCustomerLink() {
		driver.findElement(By.xpath("//a[text()='New Customer']")).click();

	}

	@When("^Input to New Customer form with data$")
	public void inputToNewCustomerFormWithData(DataTable table) {
		List<Map<String,String>> customer = table.asMaps(String.class, String.class);
		email = customer.get(0).get("Email")+randomNumber()+"@gmail.com";
		driver.findElement(By.xpath("//input[@name='name']")).sendKeys(customer.get(0).get("Name"));
		driver.findElement(By.xpath("//input[@value='"+customer.get(0).get("Gender")+"']")).click();
		
		WebElement date = driver.findElement(By.xpath("//input[@name='dob']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].setAttribute('type', 'text');", date);
		((JavascriptExecutor) driver).executeScript("arguments[0].value='"+customer.get(0).get("DateOfBirth")+"';", date);
		
		driver.findElement(By.xpath("//textarea[@name='addr']")).sendKeys(customer.get(0).get("Address"));
		driver.findElement(By.xpath("//input[@name='city']")).sendKeys(customer.get(0).get("City"));
		driver.findElement(By.xpath("//input[@name='state']")).sendKeys(customer.get(0).get("State"));
		driver.findElement(By.xpath("//input[@name='pinno']")).sendKeys(customer.get(0).get("Pin"));
		driver.findElement(By.xpath("//input[@name='telephoneno']")).sendKeys(customer.get(0).get("Phone"));
		driver.findElement(By.xpath("//input[@name='emailid']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys(customer.get(0).get("Password"));
	}

	@When("^I click to Submit button at New Customer page$")
	public void iClickToSubmitButtonAtNewCustomerPage() {
		driver.findElement(By.xpath("//input[@name='sub']")).click();

	}

	@Then("^verify message displayed with text \"([^\"]*)\"$")
	public void verifyMessageDisplayedWithTextCustomerRegisteredSuccessfully(String message) {
		driver.findElement(By.xpath("//p[@class='heading3']")).getText().equals(message);
	}

	@Then("^I verify all above information created successfull$")
	public void iVerifyAllAboveInformationCreatedSuccessfull(DataTable table){
		List<Map<String,String>> customer = table.asMaps(String.class, String.class);
		driver.findElement(By.xpath("//td[text()='Customer Name']/following-sibling::td")).getText().trim().equals(customer.get(0).get("Name"));
		driver.findElement(By.xpath("//td[text()='Gender']/following-sibling::td")).getText().trim().equals(customer.get(0).get("Gender"));
		driver.findElement(By.xpath("//td[text()='Birthdate']/following-sibling::td")).getText().trim().equals(customer.get(0).get("DateOfBirth"));
		driver.findElement(By.xpath("//td[text()='Address']/following-sibling::td")).getText().trim().equals(customer.get(0).get("Address"));
		driver.findElement(By.xpath("//td[text()='City']/following-sibling::td")).getText().trim().equals(customer.get(0).get("City"));
		driver.findElement(By.xpath("//td[text()='State']/following-sibling::td")).getText().trim().equals(customer.get(0).get("State"));
		driver.findElement(By.xpath("//td[text()='Pin']/following-sibling::td")).getText().trim().equals(customer.get(0).get("Pin"));
		driver.findElement(By.xpath("//td[text()='Mobile No.']/following-sibling::td")).getText().trim().equals(customer.get(0).get("Phone"));
		driver.findElement(By.xpath("//td[text()='Email']/following-sibling::td")).getText().trim().equals(email);
	}

	@When("^I get Customer ID at New Customer page$")
	public void iGetCustomerIDAtNewCustomerPage(){
        customerId = driver.findElement(By.xpath("//td[text()='Customer ID']/following-sibling::td")).getText().trim();
        System.out.println("Customer Id is : " + customerId);
	}
	
	public int randomNumber() {
		return new Random().nextInt(999999);
	}

}
