package commons;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.Reporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AbstractTest {

	WebDriver driver;
	protected final Log log;
	//private final String workingDir = System.getProperty("user.dir");

	public AbstractTest() {
		log = LogFactory.getLog(getClass());
	}

	public WebDriver openMultipleBrowser(String browserName, String url) {
		if (browserName.equalsIgnoreCase("chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--incognito");
			options.addArguments("--disable-extensions");
			options.addArguments("disabble-infobars");
			options.addArguments("start-maximized");
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver(options);
		} else if (browserName.equalsIgnoreCase("firefox")) {
		    WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
		} else if (browserName.equals("chromeheadless")) {
			WebDriverManager.chromedriver().setup();
			ChromeOptions options = new ChromeOptions();
			options.addArguments("headless");
			options.addArguments("window-size=1920x1080");
			driver = new ChromeDriver(options);
		} else if (browserName.equals("internetexplorer")) {
			WebDriverManager.iedriver().setup();
			driver = new InternetExplorerDriver();
		}else if (browserName.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		}

		driver.get(url);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		return driver;

	}

	public String randomEmail() {
		int rand = (int) System.currentTimeMillis();
		return "online" + rand + "@gmail.com";
	}
	
	public int randomNum() {
		return new Random().nextInt(999999);
	}

	public void closeDriver(WebDriver driver) {
		String os = System.getProperty("os.name").toLowerCase();
		String cmd = "";

		driver.quit();

		if (driver.toString().equals("chromedriver")) {
			if (os.indexOf("win") >= 0) {
				cmd = "taskkill /F /FI \"IMAGENAME eq chromedriver*\"";
			} else if (os.indexOf("mac") >= 0) {
				cmd = "pkill chromedriver";
			}
		}

		if (driver.toString().equals("internetexplorer")) {
			cmd = "taskkill /F /FI \"IMAGENAME eq IEDriverServer*\"";
		}

		try {
			Process process = Runtime.getRuntime().exec(cmd);
			process.waitFor();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}
	
	private boolean checkPassed(boolean condition) {
		boolean pass = true;
		try {
			if (condition == true)
				log.info("===PASSED===");
			else
				log.info("===FAILED===");
			Assert.assertTrue(condition);
		} catch (Throwable e) {
			pass = false;
			log.info("=== Throw error message: " + e.getMessage() + " ===\n");
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
		}
		return pass;
	}

	public boolean verifyTrue(boolean condition) {
		return checkPassed(condition);
	}

	public boolean checkFailed(boolean condition) {
		boolean pass = true;
		try {
			if (condition == true)
				log.info("===PASSED===");
			else
				log.info("===FAILED===");
			Assert.assertFalse(condition);
		} catch (Throwable e) {
			pass = false;
			log.info("=== Throw error message: " + e.getMessage() + " ===\n");
			VerificationFailures.getFailures().addFailureForTest(Reporter.getCurrentTestResult(), e);
		}
		return pass;
	}

	public boolean verifyFalse(boolean condition) {
		return checkFailed(condition);
	}

	private boolean checkEquals(Object actual, Object expected) {
		boolean pass = true;
		try {
			Assert.assertEquals(actual, expected);
		} catch (Throwable e) {
			pass = false;
			log.info(e);
		}
		return pass;
	}

	public boolean verifyEquals(Object actual, Object expected) {
		return checkEquals(actual, expected);
	}

}
