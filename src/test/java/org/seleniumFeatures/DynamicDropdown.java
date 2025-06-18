package org.seleniumFeatures;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicDropdown {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));

        driver.get("https://demoqa.com/select-menu");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 400);");

        WebElement selectOption = driver.findElement(By.xpath("//div[text()='Select Option']"));
        selectOption.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1000));
        WebElement optionToSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='Group 1, option 1']")));
        optionToSelect.click();
        System.out.println("desired option selected");

    }
}
