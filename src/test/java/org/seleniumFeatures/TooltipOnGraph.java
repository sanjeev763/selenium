package org.seleniumFeatures;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class TooltipOnGraph {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));

//        driver.get("https://clarle.github.io/yui3/yui/docs/charts/charts-pie.html");
        driver.get("https://jsfiddle.net/bsweeney/xW2MW/");

        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,250);");

//        WebElement firstSection = driver.findElement(By.xpath("(//div[@class='yui3-graph-content yui3-widget-content-expanded']//*[@pointer-events='visiblePainted'])[2]"));
//        new Actions(driver).moveToElement(firstSection).perform();
//        WebElement tooltiptext = driver.findElement(By.xpath("//div[@class='yui3-chart-tooltip']"));
//        System.out.println(tooltiptext.getText());

        WebElement mark = driver.findElement(By.cssSelector("g.highcharts-markers>path:nth-of-type(2)"));
        new Actions(driver).moveToElement(mark).perform();
        Thread.sleep(2000);
        WebElement tooltip = driver.findElement(By.cssSelector("path.highcharts-point-hover"));
        System.out.println(tooltip.getText());

    }
}
