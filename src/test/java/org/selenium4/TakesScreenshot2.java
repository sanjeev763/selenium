package org.selenium4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class TakesScreenshot2 {
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
        // this implementation is as per selenium 3
        File srcfile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcfile, new File("./target/screenshots/newscreenshot.png"));

        WebElement loginBtn = driver.findElement(By.xpath("//button[text()=' Login ']"));

        File src = ((TakesScreenshot)loginBtn).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(src, new File("./target/screenshots/login.png"));

        loginBtn.click();

        WebElement mainmenu = driver.findElement(By.xpath("//div/ul[@class='oxd-main-menu']"));
        File srcmainmenu = mainmenu.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(srcmainmenu, new File("./target/screenshots/mainmenu.png"));
    }
}
