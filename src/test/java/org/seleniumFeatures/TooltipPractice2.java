package org.seleniumFeatures;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class TooltipPractice2 {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
        driver.manage().window().maximize();
        Thread.sleep(3000);

        ((JavascriptExecutor)driver).executeScript("window.scrollBy(0, 200);");

        WebElement input = driver.findElement(By.xpath("//textarea[@aria-label='Search']"));
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(2000));
        wait.until(ExpectedConditions.visibilityOf(input));
        Actions actions = new Actions(driver);
        actions.moveToElement(input).build().perform();
        Thread.sleep(3000);
        String tooltiptext = input.getDomAttribute("title");
        System.out.println(tooltiptext);


    }
}
