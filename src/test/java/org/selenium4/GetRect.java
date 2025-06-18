package org.selenium4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.awt.*;
import java.time.Duration;

public class GetRect {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        ChromeDriver driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://app.hubspot.com/login");
        WebElement loginBox = driver.findElement(By.id("username"));
        //selenium 3
        //getSize return an instance of Dimension class
        Dimension loginboxdim = loginBox.getSize();
        System.out.println("selenium 3 - height : "+loginboxdim.getHeight());
        System.out.println("selenium 3 - width : "+ loginboxdim.getWidth());

        // getLocation return Point class
        Point p = loginBox.getLocation();
        System.out.println("selenium 3 - X coordinate : "+p.getX());
        System.out.println("selenium 3 - Y coordinate : "+p.getY());

        //selenium 4
        //getRect return Rectangle class
        Rectangle r = loginBox.getRect();
        System.out.println("selenium 4 - height : "+r.getHeight());
        System.out.println("selenium 4 - width : "+ r.getWidth());
        System.out.println("selenium 4 - X coordinate : "+r.getX());
        System.out.println("selenium 4 - Y coordinate : "+r.getY());
        // selenium internally call a javascript method getBoundingClientRect()

    }
}
