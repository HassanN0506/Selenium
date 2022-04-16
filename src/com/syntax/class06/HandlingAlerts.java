package com.syntax.class06;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingAlerts {

    /*
    handle each and every alert on the page
     */

    public static String url = "http://www.uitestpractice.com/Students/Switchto";

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
        WebElement simpleAlertButton = driver.findElement(By.id("alert"));
        simpleAlertButton.click();
        Thread.sleep(2000); //just to be able to see what is going on

        //1st we create an object of Alert interface. Then we can use all the methods of the Alert interface.
        Alert simpleAlert = driver.switchTo().alert();
         /*
        "driver.switchTo().alert()" switches selenium's focus to the alert, and it returns an object of Alert interface.
        "Alert simpleAlert = " assigns that object a name.
         */
        simpleAlert.accept();

        WebElement confirmAlertButton = driver.findElement(By.id("confirm"));
        confirmAlertButton.click();
        Thread.sleep(2000);
        Alert alert = driver.switchTo().alert(); //we can just create 1 object of Alert interface
        String alertText = alert.getText();
        System.out.println(alertText);
        alert.dismiss();

        WebElement promptAlertButton = driver.findElement(By.cssSelector("button#prompt"));
        promptAlertButton.click();
        Thread.sleep(2000);
        alert = driver.switchTo().alert(); //and then reassign that object to be HERE
        alert.sendKeys("Batch 12 is the best!");
        alert.accept();


    }
}
