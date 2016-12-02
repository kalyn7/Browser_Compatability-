package parallelTest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

public class test {

	public static void main(String args[]) {

		System.setProperty("webdriver.ie.driver", "E:\\IEDriverServer.exe");// please
																			// change
																			// the
																			// name
																			// with
																			// correspon
																			// driver
		DesiredCapabilities capabilitiesIE = DesiredCapabilities.internetExplorer();
		capabilitiesIE.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
		capabilitiesIE.setCapability("ignoreZoomSetting", true);
		WebDriver driver = new InternetExplorerDriver(capabilitiesIE);

		driver.get("http://www.gmail.com");
		String url = driver.getCurrentUrl();
		// driver.navigate().to("http://www.yahoomail.com");

		driver.navigate().back();

		driver.navigate().forward();
		String title = driver.getTitle();
		System.out.println("Title:" + title);
		String page = driver.getPageSource();
		System.out.println("Source:" + page);

	}

}
