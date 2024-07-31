package Amazon.FloraRelease;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

	public static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();

	public WebDriver initDriver() {

		tlDriver.set(new ChromeDriver());

		return getDriver();
	}

	public WebDriver getDriver() {
		return tlDriver.get();
	}

	public String getScreenshot() {
		TakesScreenshot screenShot = ((TakesScreenshot) getDriver());
		File srcFile = screenShot.getScreenshotAs(OutputType.FILE);
		String path = System.getProperty("user.dir") + "/screenShotDir/" + System.currentTimeMillis() + "_.png";

		try {
			File dest = new File(path);
			FileUtils.copyFile(srcFile, dest);

		} catch (IOException e) {
			e.printStackTrace();
		}

		return path;
	}

}
