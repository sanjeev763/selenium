package org.seleniumFeatures;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


import java.time.Duration;

public class MouseActionsPractice {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));
        driver.manage().window().maximize();
        driver.get("https://www.browserstack.com/");

        try {
            Actions action = new Actions(driver);
            WebElement pim = driver.findElement(By.linkText("Get started free"));
            //right click
            action.contextClick(pim).perform();
            System.out.println("This is right click");
            Thread.sleep(2500);

            //left click
            action.click(pim).perform();
            System.out.println("this is left click");
            Thread.sleep(2500);
            driver.navigate().back();
            Thread.sleep(2500);

            // mouse hover
            WebElement talkToUs = driver.findElement(By.xpath("//button[@data-refval='homepage_talk_to_us_hero']"));
            action.moveToElement(talkToUs).build().perform();
            System.out.println("Mouse hover");

            //double click
            WebElement doubleClickEle = driver.findElement(By.xpath("//div[@id='product-text-section']/h1"));
            action.doubleClick(doubleClickEle).perform();
            Thread.sleep(3000);
            System.out.println("This is double click");

            //click and hold
            driver.navigate().to("https://selenium08.blogspot.com/2020/01/click-and-hold.html");
            WebElement C = driver.findElement(By.xpath("//ul[@id='sortable']/li[@name='C']"));
            action.moveToElement(C);
            action.clickAndHold().perform();
            Thread.sleep(3000);
            System.out.println("Click & hold");

            // drag and drop
            WebElement B = driver.findElement(By.xpath("//ul[@id='sortable']/li[@name='B']"));
            action.dragAndDrop(C, B).perform();
            Thread.sleep(3000);
            System.out.println("drag and drop performed");

            //scroll
//            WebElement signInWithGoogle = driver.findElement(By.cssSelector("RveJvd.snByac"));
//            action.scrollToElement(signInWithGoogle).perform();
//            System.out.println("cursor scrolled to the desired element");

//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
        } finally {
            driver.quit();
        }


    }
}
