package org.selenium4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class TakeScreenshot {
    public static void main(String[] args) throws IOException {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        System.out.println("url is - "+driver.getCurrentUrl());
        WebElement username = driver.findElement(By.xpath("//input[@name='username']"));
        username.sendKeys("Admin");

        WebElement pass = driver.findElement(By.xpath("//input[@name='password']"));
        pass.sendKeys("admin123");

        // captures screenshots of full page
        // In selenium 4, TakesScreenshot class is directly implemented by WebDriver Interface whereas in selenium 3
        // we need to explicitly typecast driver into TakesScreenshot class
        File src = driver.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("./target/screenshots/fullPage.png"));

        WebElement loginBtn = driver.findElement(By.xpath("//button[text()=' Login ']"));
        captureScreenshot(loginBtn, "loginBtnScreenshot");
        loginBtn.click();
        driver.quit();
    }
    public static void captureScreenshot(WebElement element, String elementName) throws IOException {
        // captures screenshots of elements
        File src = element.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("./target/screenshots/"+elementName+".png"));
    }
}
