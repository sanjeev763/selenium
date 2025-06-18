package org.selenium4;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

public class Pdfreader {
    WebDriver driver;
    String url = "https://www.adobe.com/support/products/enterprise/knowledgecenter/media/c4611_sample_explain.pdf";
   //If we have a pdf file in our local system them open using browser option and copy the file url

    @BeforeClass
    public void setup(){
        //Open pdf in headless mode
        ChromeOptions co = new ChromeOptions();
        co.addArguments("--headless");
        driver = new ChromeDriver(co);
        driver.get(url);
    }

    @Test
    public void PdfPages() throws IOException {
        URL pdfurl = new URL(url);
        InputStream ip = pdfurl.openStream();
        BufferedInputStream bfs = new BufferedInputStream(ip);
        PDDocument pdDocument = PDDocument.load(bfs);
        int totalPages = pdDocument.getNumberOfPages();
        System.out.println(totalPages);
        Assert.assertEquals(totalPages, 4);
        //page text
        System.out.println("=======pdf content=============");
        PDFTextStripper pdfTextStripper = new PDFTextStripper();
//        String pdfText = pdfTextStripper.getText(pdDocument);
        // Start from a page number
        pdfTextStripper.setStartPage(3);
        String pdfText = pdfTextStripper.getText(pdDocument);
        System.out.println(pdfText);

    }


    @AfterClass
    public void teardown(){
        driver.quit();
    }
}
