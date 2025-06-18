package org.seleniumGrid;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

public class GoogleTest {
    @Test
    public void HomePageCheck() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setBrowserName("chrome");
//        caps.setPlatform(Platform.WINDOWS);
        options.merge(caps);
        WebDriver driver = new RemoteWebDriver(new URL("http://192.168.0.171:4444"), options);
        driver.get("http://google.com");
        System.out.println(driver.getTitle());
        driver.findElement(By.name("q")).sendKeys("sanjeev");
        driver.close();
    }

}
