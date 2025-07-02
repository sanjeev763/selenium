package org.seleniumFeatures;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class AlertsPractice {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));


        driver.get("https://demo.automationtesting.in/Alerts.html");
        WebElement alertwithok = driver.findElement(By.xpath("//a[@href='#OKTab']"));
        WebElement alertbox = driver.findElement(By.xpath("//button[@onclick='alertbox()']"));
        WebElement alertwithbuttons = driver.findElement(By.xpath("//a[@href='#CancelTab']"));
        WebElement confirmbox = driver.findElement(By.xpath("//button[@onclick='confirmbox()']"));
        WebElement alertwithtextbox = driver.findElement(By.xpath("//a[@href='#Textbox']"));
        WebElement promptbox = driver.findElement(By.xpath("//button[@onclick='promptbox()']"));

        alertwithok.click();
        alertbox.click();
        Alert alert = driver.switchTo().alert();
        alert.accept();

        alertwithbuttons.click();
        confirmbox.click();
        Alert alert1 = driver.switchTo().alert();
        System.out.println(alert1.getText());
        alert1.dismiss();


        alertwithtextbox.click();
        promptbox.click();
        Alert alert2 = driver.switchTo().alert();
        alert2.sendKeys("abcd");
        alert2.accept();
    }
}
