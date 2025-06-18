package org.selenium4;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.bidi.BiDi;
import org.openqa.selenium.bidi.BiDiSessionStatus;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.text.Bidi;
//Still getting WARNING: CDP support for Firefox is deprecated and will be removed in future versions. Please switch to WebDriver BiDi.
public class WebDriverBiDi {
    public static void main(String[] args) throws InterruptedException {
        FirefoxOptions options = new FirefoxOptions();
        //Enables webdriver BiDi
        options.setCapability("webSocketUrl", true);
        WebDriver driver = new FirefoxDriver(options);
        //Cast driver to access BiDi capabilities
        BiDi bidi = ((FirefoxDriver)driver).getBiDi();
        BiDiSessionStatus bds = bidi.getBidiSessionStatus();
        System.out.println(bds);
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        System.out.println("This is an example for BiDi");
        driver.quit();

    }
}
