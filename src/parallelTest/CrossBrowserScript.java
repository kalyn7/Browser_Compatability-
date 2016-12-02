package parallelTest;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserScript {

	WebDriver driver;

	/**
	 * This function will execute before each Test tag in testng.xml
	 * 
	 * @param browser
	 * @throws Exception
	 */
	@BeforeTest
	@Parameters("browser")
	public void setup(String browser) throws Exception {
		// Check if parameter passed from TestNG is 'firefox'
		if (browser.equalsIgnoreCase("firefox")) {
			// create firefox instance
			driver = new FirefoxDriver();
		}
		// Check if parameter passed as 'chrome'
		else if (browser.equalsIgnoreCase("chrome")) {
			// set path to chromedriver.exe
			System.setProperty("webdriver.chrome.driver", "E:\\chromedriver.exe");
			// create chrome instance
			driver = new ChromeDriver();
		}

		else {
			// If no browser passed throw exception
			throw new Exception("Browser is not correct");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	@Test
	public void testParameterWithXML() throws InterruptedException, IOException {
		driver.get("http://www.yahoomail.com");// place file in your drive
		driver.manage().window().maximize();
		// Takes screenshot
		org.openqa.selenium.Capabilities c = ((RemoteWebDriver) driver).getCapabilities();
		String b = c.getBrowserName();
		File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("E:/" + b + System.currentTimeMillis() + " Screen1.png"));

		// // Registration Page

		driver.findElement(By.id("login-signup")).click();
		driver.manage().timeouts().implicitlyWait(12, TimeUnit.SECONDS);
		driver.findElement(By.id("usernamereg-firstName")).sendKeys("Alekhya");
		driver.findElement(By.id("usernamereg-lastName")).sendKeys("Vallabhaneni");
		driver.findElement(By.id("usernamereg-password")).sendKeys("$QE_C0rp");
		driver.findElement(By.id("usernamereg-yid")).sendKeys("alekhyavallabh1");
		driver.findElement(By.id("usernamereg-phone")).sendKeys("16263625213");
		driver.findElement(By.id("usernamereg-freeformGender")).sendKeys("k");
		Select drop = new Select(driver.findElement(By.id("usernamereg-month")));
		drop.selectByValue("2");

		Select drop1 = new Select(driver.findElement(By.id("usernamereg-day")));
		drop1.selectByValue("8");
		Select drop2 = new Select(driver.findElement(By.id("usernamereg-year")));
		drop2.selectByValue("1993");
		File src1 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src1, new File("E:/" + b + System.currentTimeMillis() + " Screen2.png"));

		driver.findElement(By.id("reg-submit-button")).click();
		File src3 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src3, new File("E:/" + b + System.currentTimeMillis() + " Screen3.png"));

	}
}
