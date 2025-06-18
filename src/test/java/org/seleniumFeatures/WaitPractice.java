package org.seleniumFeatures;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class WaitPractice {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.hyrtutorials.com/p/waits-demo.html#google_vignette");
        //Implicitly wait --> It throws NoSuchElementException, it allows element/DOM to load dynamically
        //Used globally,remains in effect for the  duration of the WebDriver instance
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        //deprecated
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement textbox1btn = driver.findElement(By.xpath("//button[contains(text(),'Add Textbox1')]"));
        textbox1btn.click();
        WebElement textbox1 = driver.findElement(By.xpath("//input[@placeholder='Textbox1']"));
        System.out.println("textbox 1 is clicked");
        //Explicit wait  --> It allows webdriver to wait for specific condition, It is applied to certain element/condition dynamic in nature
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(textbox1));
        Assert.assertTrue(textbox1.isDisplayed());

        WebElement textbox2btn = driver.findElement(By.xpath("//button[contains(text(),'Add Textbox2')]"));
        textbox2btn.click();
        System.out.println("textbox 2 is clicked");
        WebElement textbox2 = driver.findElement(By.xpath("//input[@placeholder='Textbox2']"));
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait1.until(ExpectedConditions.visibilityOf(textbox2));
        Assert.assertTrue(textbox2.isDisplayed());

        //Fluent wait --> It allows polling frequency and ignoring exceptions
        driver.navigate().refresh();
        textbox2btn.click();
        System.out.println("textbox 2 is clicked again");
        Wait<WebDriver> fluentWait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(12))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        fluentWait.until(ExpectedConditions.visibilityOf(textbox2));
        Assert.assertTrue(textbox2.isDisplayed());

        driver.quit();
    }
}
