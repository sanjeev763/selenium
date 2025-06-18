package org.seleniumFeatures;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FramePractice {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://demo.automationtesting.in/Frames.html");
        driver.manage().window().maximize();

        // switch to frame by Id
        driver.findElement(By.xpath("//a[@href='#Single']")).click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 350);");

        driver.switchTo().frame("singleframe");
        List<WebElement> inputbox = driver.findElements(By.xpath("//input"));
        inputbox.get(0).sendKeys("sanjeev");
        System.out.println("inputbox on iframe is clicked");
        driver.switchTo().defaultContent();
        Thread.sleep(3000);

        // switch to iframe by webelement
        WebElement firstFrame = driver.findElement(By.xpath("//iframe[@name='SingleFrame']"));
        driver.switchTo().frame(firstFrame);
        inputbox.get(0).clear();
        Thread.sleep(3000);
        inputbox.get(0).sendKeys("testing");
        driver.switchTo().defaultContent();

        // switch to iframe by index
        driver.switchTo().frame(1);
        System.out.println("switched to iframe with index 1");
        driver.switchTo().defaultContent();

        // Frame inside frame
        driver.findElement(By.xpath("//a[@href='#Multiple']")).click();
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("window.scrollBy(0, 350);");
        WebElement firstFrame1 = driver.findElement(By.xpath("//iframe[@src='MultipleFrames.html']"));
        driver.switchTo().frame(firstFrame1);
        List<WebElement> multipleFrame = driver.findElements(By.xpath("//iframe[@src='SingleFrame.html']"));
        driver.switchTo().frame(multipleFrame.get(0));
        inputbox.get(0).sendKeys("sanjeev");
        System.out.println("inputbox on nested iframe is clicked");


        driver.close();
    }
}
