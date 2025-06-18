package org.seleniumFeatures;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class BrokenLinks {
    public static void main(String[] args) throws IOException, URISyntaxException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://ahrefs.com/broken-link-checker");
        String baseURL = driver.getCurrentUrl();
        try {
            List<WebElement> links = driver.findElements(By.tagName("a"));
            List<String> urlList = new ArrayList<>();
            for (WebElement link : links) {
                String url = link.getDomAttribute("href");
                System.out.println(url);
                if (url != null && !url.isEmpty()) {
                    if(!url.startsWith("http")){
                        url = resolveURL(baseURL, url);
                    }
                    urlList.add(url);
                    verifyUrlLink(url);
                } else {
                    System.out.println(link.getText() + " - This link is empty");
                }
            }
            /* Below lines of code are used to check the link in parallel otherwise checking each link will take alot of time
            urlList.parallelStream().forEach(e-> {
                try {
                    verifyUrlLink(e);
                } catch (IOException | URISyntaxException ex) {
                    throw new RuntimeException(ex);
                }
            });*/
        }finally {
            driver.quit();
        }

    }

    public static String resolveURL(String baseURL, String url) throws URISyntaxException {
        URI baseUri = new URI(baseURL);
        URI resolvedUri = baseUri.resolve(url);
        return resolvedUri.toString();
    }
    public static void verifyUrlLink(String stringurl) throws IOException, URISyntaxException {
        URI uri = new URI(stringurl);
        URL url = uri.toURL();
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.connect();

        int responseCode = connection.getResponseCode();
        if(responseCode >= 400){
            System.out.println("Broken Link:"+ stringurl+" - Response Code: "+responseCode);
        }else{
            System.out.println("Valid link: "+stringurl+" - Response Code: "+ responseCode);
        }
    }
}
