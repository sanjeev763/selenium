package org.seleniumFeatures;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class DesiredCapWithOptionsPractice {
    public static void main(String[] args) {
        /*
        1 Using desired capabilities we can make changes in our browser configuration before starting the execution
        2 Configure the environment in which the test will be run by specifying the browser type, version, platform etc.
        3 When browser is opened for execution, no plugin is seen. To see all the manually added plugin.
        4 To proceed with websites having unsecured certificates.
        5 Primarily used when running tests in remote environment like Selenium grid or cloud based services(Browserstack/Sauce lab)
        6 Earlier DesiredCapabilities class use to provide all the necessary capabilities, but now we have browser
        specific option to take care of these capabilities.(ChromeOptions, FirefoxOption, EdgeOptions)
        7 Proxy setting
         */
//        DesiredCapabilities caps = new DesiredCapabilities();
//        caps.setAcceptInsecureCerts(true);
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
//        options.addArguments("--start-maximized");
//        options.addArguments("--incognito"); // to open browser in incognito mode
        options.addArguments("--headless"); // to open browser in headless mode
//        options.merge(caps);
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://cacert.com"); // unsecured cert url
        System.out.println("This is implementation of Chrome options");
    }
}
