package com.syntax.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BetterWebOrders {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");

        WebDriver d = new ChromeDriver();

        d.get("http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx");

        WebElement username = d.findElement(By.id("ctl00_MainContent_username"));
        username.sendKeys("Tester");
        /*
        I can store the input-username element as a "WebElement data type" !!!!!
        and then calling the .sendKeys method onto it
         */

        WebElement password = d.findElement(By.id("ctl00_MainContent_password"));
        password.sendKeys("test");
        /*
        storing the password-input element as a WebElement named password and calling method
        This is for ease of re-usability
         */

        WebElement login = d.findElement(By.id("ctl00_MainContent_login_button"));
        login.click();

    }
}
