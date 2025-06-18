package org.seleniumFeatures;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ManageCommands {
    public static void main(String[] args) throws InterruptedException {
        /*
        Note :- In this Program Thread.sleep has been used just to see the difference with 2 millisecond time.
        */
        WebDriver driver = new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        //Manage with window
        driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.manage().window().minimize();
        Thread.sleep(2000);
        driver.manage().window().fullscreen();
        Thread.sleep(2000);
        System.out.println("getHeight - "+driver.manage().window().getSize().getHeight());
        System.out.println("getWidth - "+driver.manage().window().getSize().getWidth());
        System.out.println("getX - "+driver.manage().window().getPosition().getX());
        System.out.println("getY - "+driver.manage().window().getPosition().getY());
        Dimension d = new Dimension(500, 500);
        driver.manage().window().setSize(d);
        Thread.sleep(2000);
        Point p = new Point(200, 200);
        driver.manage().window().setPosition(p);
        Thread.sleep(2000);

        // Manage with timeouts
        System.out.println("getPageLoadTimeout - "+driver.manage().timeouts().getPageLoadTimeout());
        System.out.println("getScriptTimeout - "+driver.manage().timeouts().getScriptTimeout());
        driver.manage().timeouts().scriptTimeout(Duration.ofSeconds(5));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(5));

        // Manage with cookies
        driver.manage().deleteAllCookies();
        System.out.println("Logs - "+driver.manage().logs());
        Cookie c = new Cookie("test", "test");
        driver.manage().addCookie(c);
        System.out.println("getValue - "+c.getValue());
        System.out.println("getCookies - "+driver.manage().getCookies());
        driver.manage().deleteCookie(c);
        // or driver.manage().deleteCookieNamed("test");
        System.out.println("================== page source =========================");
        System.out.println(driver.getPageSource());
        driver.close();
    }
}
