package com.syntax.class06;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleFrames {

    public static String url = "http://www.uitestpractice.com/Students/Switchto";

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.switchTo().frame(0);                                //specifying frame by index
        WebElement textBox = driver.findElement(By.id("name"));
        textBox.sendKeys("Batch 12 Forever!!!");

        driver.switchTo().defaultContent();
        //defaultContent() is to change the focus from a frame back to the main page

        Thread.sleep(2000);
        WebElement alertButton = driver.findElement(By.id("alert"));
        alertButton.click();
        Alert alert = driver.switchTo().alert();
        Thread.sleep(1000);
        alert.accept();

        /*
        In alerts, we switch to alert, and then it switches back automatically.
        But in frames, we switch to a frame manually, and we MUST switch manually BACK to the main page.
        */

        driver.switchTo().frame("iframe_a");            //specifying frame by name (id works the same)
        textBox.clear();
        textBox.sendKeys("Yeahhhhhhh");

        driver.switchTo().defaultContent();

        //creating a WebElement of the frame so that we can pass it in the next line
        WebElement frameElement = driver.findElement(By.xpath("//iframe[@src='/Demo.html']"));
        driver.switchTo().frame(frameElement);                      //specifying frame by WebElement
        textBox.clear();
        textBox.sendKeys("Hold your horses");
    }
}
