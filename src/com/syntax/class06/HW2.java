package com.syntax.class06;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
Go to https://syntaxprojects.com/javascript-alert-box-demo.php
click on each button and handle the alert accordingly
 */
public class HW2 {

    static String url = "https://syntaxprojects.com/javascript-alert-box-demo.php";

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get(url);
        driver.manage().window().maximize();

        WebElement firstAlert = driver.findElement(By.xpath("(//button[text() = 'Click me!'])[1]"));
        firstAlert.click();
        Thread.sleep(1000);
        Alert alert = driver.switchTo().alert();
        alert.accept();

        WebElement secondAlert = driver.findElement(By.xpath("(//button[text() = 'Click me!'])[2]"));
        Thread.sleep(1000);
        secondAlert.click();
        Thread.sleep(1000);
        alert = driver.switchTo().alert();
        alert.dismiss();

        WebElement thirdAlert = driver.findElement(By.xpath("//button[text()= 'Click for Prompt Box']"));
        Thread.sleep(1000);
        thirdAlert.click();
        Thread.sleep(1000);
        alert = driver.switchTo().alert();
        alert.sendKeys("Hassan");
        Thread.sleep(1000);
        alert.accept();
        Thread.sleep(1000);

        driver.quit();

    }

}
