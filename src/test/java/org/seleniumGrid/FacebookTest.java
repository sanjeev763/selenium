package org.seleniumGrid;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class FacebookTest {
    @Test
    public void HomePageCheck2() throws MalformedURLException {
        FirefoxOptions options = new FirefoxOptions();
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(CapabilityType.BROWSER_NAME, "firefox");
        options.merge(caps);
        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.0.171:4444"), options);
        driver.get("http://facebook.com");
        System.out.println(driver.getTitle());
        driver.close();
    }


}
