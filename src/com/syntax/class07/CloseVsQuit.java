package com.syntax.class07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class CloseVsQuit {

    public static String url = "http://accounts.google.com/signup";

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();

        String mainPageHandle = driver.getWindowHandle();
        System.out.println(mainPageHandle);

        WebElement helpLink = driver.findElement(By.linkText("Help"));
        helpLink.click();

        Set<String> allWindowHandles = driver.getWindowHandles();
        System.out.println(allWindowHandles.size());

        Iterator<String> itr = allWindowHandles.iterator();
        mainPageHandle = itr.next();
        String childHandle = itr.next();

        Thread.sleep(2000);//just for visual understanding


        driver.close();
        /*
        IT CLOSES THE MAIN PAGE. WHY??????????????????????
         */
        //1 word: 'Focus'

        //even though visually we're on the 2nd tab, Selenium driver's FOCUS is still in the 1st tab.
        //so the driver.close() command was executed FOR THAT main tab that its focus was on.

        //in order to CHANGE FOCUS, we use the " .switchTo() " method

        //unless we switch the focus, ANY ACTION that is preformed will be done so on the page that the focus is on!!!!!


        Thread.sleep(2000);

        //driver.close();
        /*
        it does not work here, because THE FOCUS IS STILL ON THE MAIN PAGE
        even though that page is closed and there is only 1 tab in the browser,
        selenium webDriver's focus is STILL on that main page.
        so we get an error.
         */


        driver.switchTo().window(childHandle);
        driver.close();
        //NOW it works!

    }
}
