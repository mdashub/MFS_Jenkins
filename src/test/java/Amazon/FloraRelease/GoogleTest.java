package Amazon.FloraRelease;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GoogleTest {

	WebDriver driver;


	@Test(priority = 0)
	@Parameters("paraMdas")
	public void amazonLaunchTest(@Optional String defaultValue_Hai, String localparaMdas) {

		boolean remote = true;
		if (remote)
			remoteTest();

		else
			driver = new ChromeDriver();
		System.out.println(
				"***************************************************Passing Params from jenkins********************************************************************************** "
						+ localparaMdas);
		driver.navigate().to("https://www.google.in");
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

	@AfterClass
	public void browserClose() {
		driver.quit();
		// driver.getCurrentUrl(); //this will lead to failure and email was verified.
	}
}
