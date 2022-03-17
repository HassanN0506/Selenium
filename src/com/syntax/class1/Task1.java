package com.syntax.class1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
launch browser
navigate to amazon website
print out title and url in the console
close the browser
 */

public class Task1 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","Drivers/chromedriver.exe");
        WebDriver d1 = new ChromeDriver();
        d1.get("https://www.amazon.com/");
        String url = d1.getCurrentUrl();
        String title = d1.getTitle();
        System.out.println(title+" "+url);
        d1.quit();
    }
}
