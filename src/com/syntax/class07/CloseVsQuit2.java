package com.syntax.class07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class CloseVsQuit2 {

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


        //changing the focus to the child page and closing it:
        driver.switchTo().window(childHandle);
        driver.close();

        Thread.sleep(2000);

        /*
        NOW, the focus is STILL ON THE CHILD PAGE.
        FOCUS IS STILL ON THE CHILD PAGE. which we just closed.
        (technically the focus is nowhere because we just closed the child page.)
        (But still, we have to re-direct it's focus to where we want it to preform an action.)
        */

        //In order to preform ANY action on the main page, we must change the focus BACK to the main page!!!!!
        driver.switchTo().window(mainPageHandle);
        helpLink.click();

        //If we had tried to click on the helpLink BEFORE changing the focus back to the main page,
        // there would be an ERROR because the focus would've still been on the child page



        Thread.sleep(2000);
        driver.quit();

    }
}
