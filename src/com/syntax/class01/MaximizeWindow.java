package com.syntax.class01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MaximizeWindow {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.amazon.com/");
        driver.manage().window().maximize();
        /*
        we're telling our program to maximize the WINDOW once it's at the website.
        .manage() method to manage something,
        .window() method because we're managing the window,
        .maximize() method because we want to maximize it.
         */

        driver.manage().window().fullscreen();
        /*
        .maximize() maximizes the browser WINDOW
        .fullscreen() goes fullscreen on the WEBSITE (w/ no window control panel)
         */
    }
}
