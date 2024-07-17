package Amazon.FloraRelease;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
	/**
	 * Rigorous Test :-)
	 */

	WebDriver driver;

	@Test(priority = 0)
	public void amazonLaunchTest() {
		boolean remote = false;
		if (remote)
			remoteTest();

		else
			driver = new ChromeDriver();

		driver.navigate().to("https://www.amazon.in");
		driver.manage().window().maximize();
		// The comment

	}

	public void remoteTest() {
		// URL of the Selenium Grid Hub
		String hubUrl = "http://192.168.31.138:4444/wd/hub";

		// Desired capabilities for the browser (Chrome in this case)
		ChromeOptions options = new ChromeOptions();
		options.setCapability("browserName", "chrome");

		// Create a RemoteWebDriver instance
		try {
			driver = new RemoteWebDriver(new URL(hubUrl), options);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test(priority = 1)
	public void helpURLTest() {
		By helpLocator = By.xpath("//*[text()='Help']");
		WebElement element = driver.findElement(helpLocator);
		element.click();
		Assert.assertEquals(driver.getCurrentUrl().contains("help"), true);

	}

	@AfterClass
	public void browserClose() {
		driver.quit();
	}

}
