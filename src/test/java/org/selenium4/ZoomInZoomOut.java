package org.selenium4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ZoomInZoomOut {
    public static void main(String[] args) {
//        WebDriver driver = new ChromeDriver();
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");

        JavascriptExecutor js = (JavascriptExecutor)driver;
        //For edge, chrome, safari
        String zoomChrome = "document.body.style.zoom='50.0%'";
        //For Firefox only
        String zoomFirefox = "document.body.style.MozTransform = 'scale(0.5)';";
        js.executeScript(zoomFirefox);
    }
}
