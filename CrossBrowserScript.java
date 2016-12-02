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
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class CrossBrowserScript {

	WebDriver driver;
	
	/**
	 * This function will execute before each Test tag in testng.xml
	 * @param browser
	 * @throws Exception
	 */
	@BeforeTest
	@Parameters("browser")
	public void setup(String browser) throws Exception{
		//Check if parameter passed from TestNG is 'firefox'
		if(browser.equalsIgnoreCase("firefox")){
		//create firefox instance
			driver = new FirefoxDriver();
		}
		//Check if parameter passed as 'chrome'
		else if(browser.equalsIgnoreCase("chrome")){
			//set path to chromedriver.exe
			System.setProperty("webdriver.chrome.driver",".\\chromedriver.exe");
			//create chrome instance
			driver = new ChromeDriver();
		}
		//Check if parameter passed as 'opera'
				else if(browser.equalsIgnoreCase("opera")){
					//set path to IE.exe
					System.setProperty("webdriver.opera.driver",".\\operadriver.exe");
					//create IE instance
					driver = new OperaDriver();
				}
		else{
			//If no browser passed throw exception
			throw new Exception("Browser is not correct");
		}
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	@Test
	public void testParameterWithXML() throws InterruptedException, IOException{
		driver.get("file:///F:/Alekhya/registn.html");// place file in your drive
		
		//Takes screenshot
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("D:/Screen1.png"));
//		// Registration Page
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(By.id("fname")).sendKeys("Alekhya");
		driver.findElement(By.id("lname")).sendKeys("Vallabhaneni");
		driver.findElement(By.id("uname")).sendKeys("avallabhaneni33");
		driver.findElement(By.id("email")).sendKeys("avallabhaneni@gmail.com");
		driver.findElement(By.id("pwd")).sendKeys("Alekhya1234");
		driver.findElement(By.id("cpwd")).sendKeys("Alekhya1234");
		driver.findElement(By.id("gnf")).click();
		boolean b=driver.findElement(By.id("gnf")).isSelected();
		System.out.print(b);
		driver.findElement(By.id("dob")).sendKeys("08-07-92");
		driver.findElement(By.id("pnum")).sendKeys("123456");
		driver.findElement(By.id("address")).sendKeys("jkjkjkjkj");
		 Select drop=new Select(driver.findElement(By.id("country")));
		 drop.selectByValue("India");
		 driver.findElement(By.id("ag")).click();
		 File src1= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src1, new File("D:/Screen2.png"));
			driver.findElement(By.id("sub")).click();
			 File src2= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				FileUtils.copyFile(src2, new File("D:/Screen3.png"));
				
				
		

	}
}
