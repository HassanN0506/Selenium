package com.syntax.class2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatingElements {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.facebook.com/");

        driver.findElement(By.id("email")).sendKeys("syntax@whatever.com");

        driver.findElement(By.id("pass")).sendKeys("blah blah blah");

        driver.findElement(By.name("login")).click();

        Thread.sleep(2000);

        //driver.findElement(By.linkText("Forgot password?")).click();
        driver.findElement(By.partialLinkText("Forgot")).click();

        driver.quit();
    }
}
