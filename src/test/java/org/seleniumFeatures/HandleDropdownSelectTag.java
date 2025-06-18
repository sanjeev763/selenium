package org.seleniumFeatures;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.Objects;

public class HandleDropdownSelectTag {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3000));
        driver.get("https://demoqa.com/select-menu");
        JavascriptExecutor js = (JavascriptExecutor)driver;
        js.executeScript("window.scrollBy(0 ,600);");

        // Drop down with Select tags
//        WebElement dropdown = driver.findElement(By.id("oldSelectMenu"));
//        dropdown.click();
//        System.out.println("dropdown is clicked");
//        Select select = new Select(dropdown);
//        // select by index
//        select.selectByIndex(2);
//        System.out.println("Green is selected");
//        Thread.sleep(2000);
//        // select by value
//        select.selectByValue("red");
//        System.out.println("Red is selected");
//        Thread.sleep(2000);
//        select.selectByValue("3");
//        System.out.println("Yellow is selected");
//        Thread.sleep(2000);
//        // select by visible text
//        select.selectByVisibleText("Purple");
//        System.out.println("Purple is selected");
//        Thread.sleep(2000);
//        // first selected option
//        select.getFirstSelectedOption();
//        System.out.println("Printing First selected option");
//        Thread.sleep(2000);
//
//        //Get all Options from dropdown
//        List<WebElement> optionsList = select.getOptions();
//        for(WebElement ele : optionsList){
//            System.out.println(ele.getText());
//            if (Objects.equals(ele.getText(), "Aqua"))
//                ele.click();
//        }

        // Multi select dropdown
        WebElement multiselect = driver.findElement(By.id("cars"));
        Select selectnew = new Select(multiselect);
        Assert.assertTrue(selectnew.isMultiple());
        selectnew.selectByValue("volvo");
        selectnew.selectByValue("audi");
        selectnew.selectByVisibleText("Opel");
        System.out.println(selectnew.getFirstSelectedOption().getText());
        List<WebElement> allSelected = selectnew.getAllSelectedOptions();
        for(WebElement selected : allSelected){
            System.out.println(selected.getText());
        }
        Thread.sleep(3000);
        selectnew.deselectByValue("opel");
        Thread.sleep(2500);
        selectnew.deselectAll();

        driver.quit();
    }
}
