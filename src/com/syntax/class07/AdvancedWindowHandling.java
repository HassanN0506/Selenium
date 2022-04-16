package com.syntax.class07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class AdvancedWindowHandling {

    /*
    click on buttons and open new windows (tabs)
    switch through the windows and preform different actions
     */

    public static String url = "http://syntaxprojects.com/window-popup-modal-demo.php";

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();

        String mainPageHandle = driver.getWindowHandle();

        WebElement followIgButton = driver.findElement(By.linkText("Follow On Instagram"));
        WebElement likeFbButton = driver.findElement(By.linkText("Like us On Facebook"));
        WebElement followIgAndFbButton = driver.findElement(By.linkText("Follow Instagram & Facebook"));

        followIgButton.click();
        likeFbButton.click();
        followIgAndFbButton.click();

        Set<String> allWindowHandles = driver.getWindowHandles();
        System.out.println(allWindowHandles.size());

        Iterator<String> itr = allWindowHandles.iterator();
        while(itr.hasNext()){   //start iterating through the handles
            String handle = itr.next();     //get the next available handle
            if(!mainPageHandle.equals(handle)) {    //set a condition: as long as it's not the main window
                driver.switchTo().window(handle);    //switch to the present window
                String title = driver.getTitle();
                System.out.println(title);
                driver.close();
            }
        }

        driver.switchTo().window(mainPageHandle);   //switch focus back to the "Parent Handle"
        followIgButton.click();

    }
}
