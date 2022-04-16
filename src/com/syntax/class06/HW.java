package com.syntax.class06;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW {

    static String url = "https://syntaxprojects.com/bootstrap-iframe.php";

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //Navigate to https://syntaxprojects.com/bootstrap-iframe.php
        driver.get(url);

        Thread.sleep(2000);

        //verify the header is displayed
        WebElement headerText = driver.findElement(By.cssSelector("span.gum"));
        if(headerText.isDisplayed()){
            System.out.println("Header text IS displayed");
        } else {
            System.out.println("Header text is NOT displayed");
        }

        //verify 'REGISTER FOR FREE'' button is enabled
        driver.switchTo().frame("FrameOne");
        WebElement registerButton = driver.findElement(By.id("makaha-ButtonElement--XMO5BoJfiAVGcnXXwIIj"));
        System.out.println("Register button is enabled: "+registerButton.isEnabled());
        driver.quit();

    }
}
