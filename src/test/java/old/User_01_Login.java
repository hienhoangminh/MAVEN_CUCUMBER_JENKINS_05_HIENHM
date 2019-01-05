package old;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class User_01_Login{
	
	WebDriver driver;
	
	@Given("^I navigate to bank guru site$")
	public void iNavigateToBankGuruSite() throws Throwable {
	   System.setProperty("webdriver.chrome.driver", "src//test//resources//chromedriver");
	   driver = new ChromeDriver();
	   driver.get("http://demo.guru99.com/v4/");
	   driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	   
	}

	@When("^I input to username \"([^\"]*)\"$")
	public void iInputToUsername(String userId) throws Throwable {
	   driver.findElement(By.xpath("//input[@name='uid']")).sendKeys(userId);
	}

	@When("^I input to password \"([^\"]*)\"$")
	public void iInputToPassword(String userPass) throws Throwable {
	   driver.findElement(By.xpath("//input[@name='password']")).sendKeys(userPass);

	}

	@When("^I click to Login button$")
	public void iClickToLoginButton() throws Throwable {
	   driver.findElement(By.xpath("//input[@name='btnLogin']")).click();
	}

	@Then("^I verify Homepage displayed with message \"([^\"]*)\"$")
	public void iVerifyHomepageDisplayed(String message) {
	    driver.findElement(By.xpath("//marquee[text()=\""+message+"\"]")).isDisplayed();
	}

	@Then("^I close browser$")
	public void iCloseBrowser() throws Throwable {
	    driver.quit();
	}

}
