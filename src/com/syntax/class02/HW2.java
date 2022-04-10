package com.syntax.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
navigate to fb.com
click on create new account
fill up all the textboxes
click on sign up button
close the pop up
close the browser
 */

public class HW2 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();

        WebElement createNewAccountButton = driver.findElement(By.linkText("Create new account"));
        createNewAccountButton.click();

        Thread.sleep(2000);
        driver.findElement(By.name("firstname")).sendKeys("Ha");
        driver.findElement(By.name("lastname")).sendKeys("Na");
        driver.findElement(By.name("reg_email__")).sendKeys("703-703-7033");
        driver.findElement(By.name("reg_passwd__")).sendKeys("abc123!");

        Thread.sleep(2000);
        driver.quit();
    }
}
