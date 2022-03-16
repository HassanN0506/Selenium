package com.company.class1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchBrowser {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        //Specify which driver you want to use in the 1st " "
        //Tell IDE where to find that driver in the 2nd " "
        //You can also use "\\" after the "Drivers" (instead of "/")

        WebDriver driver = new ChromeDriver();
        //Creating an object of the WebDriver INTERFACE through ChromeDriver subclass
        // (because we can't DIRECTLY make an object of an interface)
        //WebDriver and ChromeDriver come from the Selenium Library
        //This line will simply Open Google Chrome (because we're using ChromeDriver), and go to a Blank page.

        driver.get("https://www.google.com/");
        //Telling object named "driver" to perform the ".get" method
        //So we're telling our driver to go to google.com

        String url = driver.getCurrentUrl();
        System.out.println(url);
        //We're telling driver to get the url of the current position of the WebDriver
        // and storing that in the string and printing it out.

        String title = driver.getTitle();
        System.out.println(title);
        //We're telling driver to get the "title" of the current page that the WebDriver is on
        // and storing that in the string and printing it out. (title is written on chrome's tab for that website)

        driver.quit();
        //Telling driver to exit out of Google Chrome.

    }

}
