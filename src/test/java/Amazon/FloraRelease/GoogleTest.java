package Amazon.FloraRelease;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import Utils.HelperUtils;

public class GoogleTest extends HelperUtils {

	WebDriver driver;

	@Test(priority = 0)
	public void amazonLaunchTest() {

		boolean remote = true;
		if (remote) {
			remoteTest();
		}

		driver = new ChromeDriver();
		driver.navigate().to("https://www.google.in");
		driver.manage().window().maximize();
		// The comment

	}

	@AfterClass
	public void browserClose() {
		driver.quit();
		// driver.getCurrentUrl(); //this will lead to failure and email was verified.
	}
}
