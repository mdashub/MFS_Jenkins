package Amazon.FloraRelease;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

public class GoogleTest {

	

	WebDriver driver;

	@Test(priority = 0)
	public void amazonLaunchTest() {
		driver = new ChromeDriver();
		driver.navigate().to("https://www.google.in");
		driver.manage().window().maximize();
		// The comment

	}

	

	@AfterClass
	public void browserClose() {
		driver.quit();
		driver.getCurrentUrl(); //this will lead to failure 
	}
}
