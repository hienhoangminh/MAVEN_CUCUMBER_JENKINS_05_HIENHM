package cucumberOptions;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks {

	private static WebDriver driver;
	private static final Logger log = Logger.getLogger(Hooks.class.getName());

	@Before
	public synchronized static WebDriver openBrowser() {
		// Run by Maven command line
		String browser = System.getProperty("BROWSER");
		String os = System.getProperty("os.name");
		ChromeOptions options;

		if (driver == null) {
			try {
				// Kiem tra BROWSER = null -> gan = chrome
				if (browser == null) {
					browser = System.getenv("BROWSER");
					if (browser == null) {
						browser = "firefox";
					}
				}

				switch (browser) {
				case "chrome":
					options = new ChromeOptions();
					options.addArguments("--incognito");
					options.addArguments("--disable-extensions");
					options.addArguments("disabble-infobars");
					options.addArguments("start-maximized");
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver(options);
					break;
				case "hchrome":
					WebDriverManager.chromedriver().setup();
					options = new ChromeOptions();
					options.addArguments("headless");
					options.addArguments("window-size=1920x1080");
					driver = new ChromeDriver(options);
					break;
				case "firefox":
					driver = new FirefoxDriver();
					break;
				case "hfirefox":
					break;
				case "ie":
					System.setProperty("webdriver.ie.driver", ".\\src\\test\\resources\\IEDriverServer.exe");
					driver = new InternetExplorerDriver();
					break;
				default:
					options = new ChromeOptions();
					options.addArguments("--incognito");
					options.addArguments("--disable-extensions");
					options.addArguments("disabble-infobars");
					options.addArguments("start-maximized");
					WebDriverManager.chromedriver().setup();
					driver = new ChromeDriver(options);
					break;
				}
			} catch (UnreachableBrowserException e) {
				driver = new ChromeDriver();
			} catch (WebDriverException e) {
				driver = new ChromeDriver();
			} finally {
				Runtime.getRuntime().addShutdownHook(new Thread(new BrowserCleanup()));
			}

			driver.get("http://demo.guru99.com/v4/");
			driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			log.info("------------- Started the browser -------------");
		}
		return driver;
	}

	public static void close() {
		try {
			if (driver != null) {
				openBrowser().quit();
				log.info("------------- Closed the browser -------------");
			}
		} catch (UnreachableBrowserException e) {
			System.out.println("Can not close the browser");
		}
	}

	private static class BrowserCleanup implements Runnable {
		public void run() {
			close();
		}
	}

}
