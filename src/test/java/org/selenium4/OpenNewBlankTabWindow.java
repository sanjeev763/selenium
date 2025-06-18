package org.selenium4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class OpenNewBlankTabWindow {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        driver.get("https://app.hubspot.com/login");
        System.out.println(driver.getTitle());
        //Opens a new blank tab
//        driver.switchTo().newWindow(WindowType.TAB);
        System.out.println("getting no title - "+driver.getTitle());
        //Opens a new blank window
        driver.switchTo().newWindow(WindowType.WINDOW);
        Set<String> windows = driver.getWindowHandles();
        List<String> ls = new ArrayList<>(windows);
        String Parentwindow = ls.get(0);
        String Childwindow = ls.get(1);
        System.out.println(Parentwindow);
        System.out.println(Childwindow);

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        System.out.println("After switching - "+driver.getTitle());
        driver.close();
        driver.switchTo().window(Parentwindow);
        System.out.println("driver is lost/found - "+driver.getTitle());





    }
}
