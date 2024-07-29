package Amazon.FloraRelease;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.InvalidSelectorException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class GoogleTest {

	WebDriver driver;

	@Test(priority = 0)
	@Parameters("paraMdas")
	public void amazonLaunchTest(@Optional String defaultValue_Hai) {

		boolean remote = false;
		if (remote)
			remoteTest();

		else
			driver = new ChromeDriver();
		System.out.println(
				"***************************************************Passing Params from jenkins********************************************************************************** "
						+ defaultValue_Hai);
		driver.navigate().to("https://www.google.in");
		driver.manage().window().maximize();
		
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		// The comment
		/*
		 * Actions act = new Actions(driver);
		 * 
		 * //act.sendKeys(driver.findElement(By.xpath("")), "SE");
		 * 
		 * JavascriptExecutor js = (JavascriptExecutor) driver; //
		 * js.executeScript(null, null);
		 * 
		 * driver.get(driver.getCurrentUrl()); driver.navigate().refresh();
		 * driver.navigate().forward(); driver.navigate().back();
		 * 
		 * js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		 * 
		 * WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 * wait.pollingEvery(Duration.ofMillis(200)).ignoring(NoSuchElementException.
		 * class).ignoring(InvalidSelectorException.class);;
		 */
		//wait.until(ExpectedConditions.elementSelectionStateToBe(driver.findElement(By.xpath("")), true));

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
