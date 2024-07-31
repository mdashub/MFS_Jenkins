package Amazon.FloraRelease;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * Unit test for simple App.
 */
public class AppTest {
	/**
	 * Rigorous Test :-)
	 */

	public WebDriver driver;
	@BeforeTest
	public void driverInitilization() {
		DriverFactory driverfactory = new DriverFactory();
		driver = driverfactory.initDriver();
	}

	
	@Test(priority = 1,description = "This test verifes that Amazon INDIA is launched")
	public void amazonLaunchTest() {


		driver.navigate().to("https://www.amazon.in");
		driver.manage().window().maximize();
		// The comment

	}

	@Test(priority = 2, description = "To verify Help Url is active on footer note")
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
