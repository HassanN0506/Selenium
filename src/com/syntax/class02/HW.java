package com.syntax.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*
HW
navigate to https://parabank.parasoft.com/parabank/register.htm;jsessionid=B8DD31FF0AFEDBDF4454B27BBC5C05B0%22
fill out the form
click on register
close the browser
*/

public class HW {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://parabank.parasoft.com/parabank/register.htm;jsessionid=B8DD31FF0AFEDBDF4454B27BBC5C05B0%22");
        driver.manage().window().maximize();

        WebElement firstName = driver.findElement(By.id("customer.firstName"));
        firstName.sendKeys("Hassan");
        WebElement lastName = driver.findElement(By.id("customer.lastName"));
        lastName.sendKeys("Nawaz");
        WebElement address = driver.findElement(By.id("customer.address.street"));
        address.sendKeys("123 Main St");
        WebElement city = driver.findElement(By.id("customer.address.city"));
        city.sendKeys("DC");
        WebElement state = driver.findElement(By.id("customer.address.state"));
        state.sendKeys("n/a");
        WebElement zipCode = driver.findElement(By.id("customer.address.zipCode"));
        zipCode.sendKeys("123456");
        WebElement phoneNum = driver.findElement(By.id("customer.phoneNumber"));
        phoneNum.sendKeys("703-703-7033");
        WebElement ssn = driver.findElement(By.id("customer.ssn"));
        ssn.sendKeys("123-12-1234");
        WebElement username = driver.findElement(By.id("customer.username"));
        username.sendKeys("la-di-da");
        WebElement password = driver.findElement(By.id("customer.password"));
        password.sendKeys("abc123!");
        WebElement confirmPassword = driver.findElement(By.id("repeatedPassword"));
        confirmPassword.sendKeys("abc123!");

        Thread.sleep(5000);
        WebElement registerButton = driver.findElement(By.className("button"));
        registerButton.click();

        Thread.sleep(5000);
        driver.quit();

    }
}
