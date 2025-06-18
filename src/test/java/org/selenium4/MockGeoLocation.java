package org.selenium4;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;


public class MockGeoLocation {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        Map<String, Object> coordinates = new HashMap<>();
        coordinates.put("latitude", 34.0549);
        coordinates.put("longitude", -118.2426);
        coordinates.put("accuracy", 1);

        ((ChromeDriver)driver).executeCdpCommand("Emulation.setGeolocationOverride", coordinates);
        driver.get("https://oldnavy.gap.com/stores");

    }
}
