package org.seleniumFeatures;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class NavigationCommands {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        System.out.println(driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "OrangeHRM");
        driver.navigate().refresh();
        System.out.println("After refresh - "+driver.getTitle());
        driver.navigate().to("https://www.google.com/");
        System.out.println("After using navigate to - "+driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Google");
        driver.navigate().back();
        System.out.println("After using back - "+driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "OrangeHRM");
        driver.navigate().forward();
        System.out.println("After using forward - "+driver.getTitle());
        Assert.assertEquals(driver.getTitle(), "Google");
        driver.quit();
    }
}
