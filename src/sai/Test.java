package sai;
 

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class Test {
	
	public static void main(String args[]) throws IOException
	{
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

		WebDriver driver=new ChromeDriver();
		driver.get("http://www.gmail.com");
		//Takes screenshot
		File src= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C:\\Users\\kalya\\Desktop\\Screenshots\\Screen1.png"));
		//Gmail Registration Page
		driver.findElement(By.id("link-signup")).click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
		driver.findElement(By.id("FirstName")).sendKeys("Alekhya");
		driver.findElement(By.id("LastName")).sendKeys("Vallabhaneni");
		driver.findElement(By.id("GmailAddress")).sendKeys("avallabhaneni33");
		driver.findElement(By.id("Passwd")).sendKeys("Alekhya1234");
		driver.findElement(By.id("PasswdAgain")).sendKeys("Alekhya1234");
		//month
		driver.findElement(By.id("BirthMonth")).click();
		driver.findElement(By.id(":7")).click();
		//month end
		driver.findElement(By.id("BirthDay")).sendKeys("08");
		driver.findElement(By.id("BirthYear")).sendKeys("1992");
		//gender
		driver.findElement(By.id("Gender")).click();
		driver.findElement(By.id(":e")).click();
		//gen end
		driver.findElement(By.id("RecoveryPhoneNumber")).sendKeys("9095679810");
		driver.findElement(By.id("RecoveryEmailAddress")).sendKeys("alekhyavallabhaneni92@gmail.com");
		
		//screenshot2
		File src1= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src1, new File("C:\\Users\\kalya\\Desktop\\Screenshots\\Screen2.png"));
		
		 //Submit page
		driver.findElement(By.id("submitbutton")).click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		//Agree Page Screenshot
		File src3= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src3, new File("C:\\Users\\kalya\\Desktop\\Screenshots\\Screen3.png"));
		//driver.close();
		
	}

}
