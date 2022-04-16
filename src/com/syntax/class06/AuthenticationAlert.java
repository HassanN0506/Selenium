package com.syntax.class06;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class AuthenticationAlert {

    public static String url = "https://admin:admin@the-internet.herokuapp.com/basic_auth";
    //When there is a username and password authentication popup asap, it has to be taken care of in the url
    //Syntax: https://username:password@restOfTheURL
    //Example: https://admin:admin@restOfTheURL

    //this is an "Authentication alert"
    //we cannot just use the sendKeys() method here

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

    }
}
