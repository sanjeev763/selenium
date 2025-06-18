package org.seleniumFeatures;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class KeyboardKeysPractice {
    public static void main(String args[]) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
        driver.get("https://demoqa.com/text-box");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 200);");

        Actions actions = new Actions(driver);
        WebElement username = driver.findElement(By.id("userName"));
        actions.sendKeys(username, "sanjeev").perform();
        Thread.sleep(2500);
        actions.keyDown(Keys.TAB).perform();
        actions.keyDown(Keys.SHIFT).keyDown(Keys.TAB).build().perform();

        // Select All - Copy - Paste
        WebElement currentAdd = driver.findElement(By.id("currentAddress"));
        currentAdd.sendKeys("vi-kothiya");
        actions.doubleClick(currentAdd).keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
        actions.keyDown(Keys.TAB).perform();
        actions.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
        Thread.sleep(5000);
        System.out.println("copy - paste");
        driver.quit();
    }
}
