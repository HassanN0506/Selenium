package com.syntax.class1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class NavigateMethod {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver d1 = new ChromeDriver(); //open chrome 1 time
        d1.get("https://www.facebook.com/"); //go to facebook
        d1.navigate().to("https://www.google.com/");
        //".navigate().to()" is another way to go to a webpage
        //Now, ON THE SAME TAB, ON THE SAME BROWSER, it'll leave facebook and go to google.com
        //because we didn't specify differently
        d1.navigate().back();
        d1.navigate().forward();
        //method chaining to navigate back and forward
        /*
        the difference between .get() and .navigate() is that .navigate() allows us to do more things
        like go back to the previous page, go forward to the other page, etc.
         */

        Thread.sleep(2000);
        //This tells the execution to pause for 2 seconds before moving on to the next step,
        // so we can better see visually what is going on during the execution (because it happens fast).
        //(it gives an error ar first, so just select the "add exception" option for now)

        d1.navigate().refresh();
        //refreshes the page

        d1.close();
        //closes the browser (because we only have 1 tab open in the browser)
        /*
        .close() closes ONLY the current TAB.
        .quit() closes the ENTIRE BROWSER.
         */
    }
}
