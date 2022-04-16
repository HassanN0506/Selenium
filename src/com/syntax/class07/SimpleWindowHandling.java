package com.syntax.class07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class SimpleWindowHandling {

    /*
    click on Help link
    switch between tabs
     */

    public static String url = "http://accounts.google.com/signup";

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();

        //getting the main page's handle and storing it in a string:
        String mainPageHandle = driver.getWindowHandle();
        System.out.println(mainPageHandle);

        //clicking on help button:
        WebElement helpLink = driver.findElement(By.linkText("Help"));
        helpLink.click();
        //automatically gets taken to another page in a new tab

        //getting the ALL pages' handles and storing them in a Set:
        Set <String> allWindowHandles = driver.getWindowHandles();

        //if I want to know HOW MANY tabs I have:
        System.out.println(allWindowHandles.size());

        //Have to create an iterator in order to go switch between tabs
        Iterator<String> itr = allWindowHandles.iterator();

        mainPageHandle = itr.next(); //Telling the iterator to make THIS be the first step!!!!!!!!!!
        //(and it moved forward 1, because we said "itr.next()". So now we are ON the 1st element.)
        /*
        We must tell the iterator which element to START with
        (because it technically starts BEFORE the first element, by default)
         */

        String childHandle = itr.next();
        //now the iterator is on the second tab (the 'child' tab), and getting it's handle


        Thread.sleep(1000);//just for visual understanding


        //we are currently on the 2nd page in the browser, because we click on the Help link
        //We need to switch in between these 2 'windows'(tabs):

        //to switch back to the main page:
        driver.switchTo().window(mainPageHandle);

        Thread.sleep(1000);

        //to switch back to the 2nd tab:
        driver.switchTo().window(childHandle);

        Thread.sleep(1000);


        //to switch back and forth a couple more times:
        driver.switchTo().window(mainPageHandle);
        Thread.sleep(1000);
        driver.switchTo().window(childHandle);
        Thread.sleep(1000);

        driver.switchTo().window(mainPageHandle);
        Thread.sleep(1000);
        driver.switchTo().window(childHandle);
        Thread.sleep(1000);


        driver.quit();

    }
}
