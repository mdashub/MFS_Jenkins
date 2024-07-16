package Utils;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

public class HelperUtils {

	public void remoteTest() {
		// URL of the Selenium Grid Hub
		String hubUrl = "http://localhost:4444/wd/hub";

		// Desired capabilities for the browser (Chrome in this case)
		ChromeOptions options = new ChromeOptions();
		options.setCapability("browserName", "chrome");

		// Create a RemoteWebDriver instance
		try {
			WebDriver driver = new RemoteWebDriver(new URL(hubUrl), options);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
