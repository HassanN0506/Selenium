package com.syntax.class08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class HandlingDynamicTables {

    static String url = "http://secure.smartbearsoftware.com/samples/testcomplete11/WebOrders/login.aspx";

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

        //logging in:
        driver.findElement(By.id("ctl00_MainContent_username")).sendKeys("Tester");
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();


        //creating a list of the table's rows Excluding the Header:
        List<WebElement> rows = driver.findElements(By.xpath("//table[@class='SampleTable']/tbody/tr"));

        for(int i=1; i < rows.size(); i++){
        //START FROM ZERO, BECAUSE WE'RE LOOPING THROUGH BASED ON THE LIST'S INDEXES, NOT THE XPATH'S INDEXES!!!!!
        //(though here I am starting form 1 to exclude the Header)

            String rowText = rows.get(i).getText();
            System.out.println(rowText);

            //I want to click on the checkbox for 'Bob Feather'

            //1st, I make a list of checkbox WebElements:
            List<WebElement> checkboxes = driver.findElements(By.xpath("//table[@class='SampleTable']/tbody/tr/td[1]"));

            //Then, I check if the row's data contains the name 'Bob Feather':
            if(rowText.contains("Bob Feather")){
                //And I click on THAT (the row whose text contains 'Bob Feather') checkbox
                checkboxes.get(i-1).click();
                //I have to do i-1 to make up for the fact that my loop starts w/ i=1   !!!!!
                //(I did i=1 in the loop to exclude the header,
                // and so it doesn't match up with my indexes in this checkboxes List.)
            }
        }
        /*
        Although, you're wasting a lot of memory by creating a list of checkboxes every single time you loop.
        It would be more efficient if you were to put the List checkboxes INSIDE the If condition.      !!!!!
         */


        //driver.close();

    }
}
