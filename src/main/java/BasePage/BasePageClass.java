package BasePage;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BasePageClass {
	
	WebDriver driver;
	
	public WebDriver initWebDriver(String browser, String platform, String testName) {
		
		if(browser.equalsIgnoreCase("chrome")) {
		ChromeOptions options = new ChromeOptions();
		MutableCapabilities mcq = new MutableCapabilities();
		options.setPlatformName(platform);
		options.setBrowserVersion("latest");
		mcq.setCapability("username", "oauth-chaitanyanandams-bead2");
		mcq.setCapability("accessKey", "c1b473e1-20c8-4d5a-bb76-a09098d08807");
		mcq.setCapability("name", testName);
		options.setCapability("sauce:options", mcq);
		try {
			driver = new RemoteWebDriver(new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub"),options);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
		 else if(browser.equalsIgnoreCase("firefox")) {
			FirefoxOptions options = new FirefoxOptions();
			MutableCapabilities mcq = new MutableCapabilities();
			options.setPlatformName(platform);
			options.setBrowserVersion("latest");
			mcq.setCapability("username", "oauth-chaitanyanandams-bead2");
			mcq.setCapability("accessKey", "c1b473e1-20c8-4d5a-bb76-a09098d08807");
			mcq.setCapability("name", testName);
			options.setCapability("sauce:options", mcq);
			try {
				driver = new RemoteWebDriver(new URL("https://ondemand.eu-central-1.saucelabs.com:443/wd/hub"),options);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		return driver;
	}

}
