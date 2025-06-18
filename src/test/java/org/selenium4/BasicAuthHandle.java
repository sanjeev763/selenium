package org.selenium4;

import com.google.common.primitives.Bytes;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.codec.EncoderException;
import org.apache.commons.codec.binary.Base64;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v130.network.Network;
import org.openqa.selenium.devtools.v130.network.model.Headers;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class BasicAuthHandle {
    private static final String username = "admin";
    private static final String password = "admin";
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        DevTools devtool = ((ChromeDriver)driver).getDevTools();
        devtool.createSession();
        devtool.send(Network.enable(Optional.empty(),Optional.empty(),Optional.empty()));

        Map<String, Object> header = new HashMap<>();
        String basicAuth = "Basic" + new String(new Base64().encode(String.format("%s,%s", username, password).getBytes()));
        header.put("Authorization", basicAuth);

        devtool.send(Network.setExtraHTTPHeaders(new Headers(header)));
        driver.get("https://the-internet.herokuapp.com/basic_auth");
    }
}
