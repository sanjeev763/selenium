package org.seleniumFeatures;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class TooltipPractice {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2000));

        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.findElement(By.name("username")).sendKeys("Admin");
        driver.findElement(By.name("password")).sendKeys("admin123");
        driver.findElement(By.xpath("//button[@type='submit']")).click();

        WebElement piechart = driver.findElement(By.xpath("(//ul[@class='oxd-chart-legend'])[2]"));
        Actions actions = new Actions(driver);
//        actions.moveToElement(piechart).perform();
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true)", piechart);
        Thread.sleep(3000);
       int canvasX =  piechart.getRect().getX();
       int canvasY =  piechart.getRect().getY();
       int canvasHeight = piechart.getRect().getHeight();
       int canvasWidth = piechart.getRect().getWidth();
       int targetX = canvasX + (int)(canvasWidth * 0.7);
       int targetY = canvasY + (int)(canvasHeight * 0.3);
       JavascriptExecutor js = (JavascriptExecutor) driver;
       String script = "var piechart = arguments[0];" + "var rect = piechart.getBoundingClientRect();" +
               "var x = arguments[1] - rect.left;" + "var y = arguments[2] - rect.top;" +
               "var event = new MouseEvent('mousemove',{"+"bubbles:true,"+ "cancelable:true"+"clientX: arguments[1],"+"clientY: arguments[2]"+
               "});" + "piechart.dispatchEvent(event);";
       js.executeAsyncScript(script, piechart, targetX, targetY);
       Thread.sleep(2000);
       WebElement tooltip = driver.findElement(By.xpath("//*[contains(text(),'Unassigned')]"));
       System.out.println(tooltip.getText());

       driver.quit();
    }
}
