package Amazon.FloraRelease;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
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
		driver = new ChromeDriver();
		driver.navigate().to("https://www.amazon.in");
		driver.manage().window().maximize();
		// The comment

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
