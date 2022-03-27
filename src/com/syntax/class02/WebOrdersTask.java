package com.syntax.class02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebOrdersTask {

    public static void main(String[] args) {
 /*
 * Task
 * Navigate to http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx
 * Login
 * Get title and verify
 * logout
 * close the browser
 */
         System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
         WebDriver d = new ChromeDriver();
         d.get("http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx");
         d.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
         d.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
         d.findElement(By.id("ctl00_MainContent_login_button")).click();
         String title = d.getTitle();
         String expectedTitle = "Web Orders";
         if(title.equals(expectedTitle)){
             System.out.println("Title is correct");
         } else {
             System.out.println("Title is incorrect");
         }
         d.findElement(By.id("ctl00_logout")).click();
         d.quit();
    }
}
