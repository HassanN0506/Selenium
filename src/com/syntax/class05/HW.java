package com.syntax.class05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/*

HW1
Go to facebook sign up page
Fill out the whole form
Click signup

HW2
Go to ebay.com
get all the categories and print them in the console
select Computers/Tables & Networking
click on search
verify the header
 */
public class HW {
    public static void main(String[] args) {
        /*
        Open chrome browser
        Go to "https://www.facebook.com"
        click on create new account
        Verify:
        month dd has 12 month options
        day dd has 31 day options
        year dd has 115 year options
        Select your date of birth
        Quit browser
         */
        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.facebook.com");
        driver.manage().window().maximize();

        WebElement createNewAccountButton = driver.findElement(By.linkText("Create new account"));
        createNewAccountButton.click();

        //WebElement monthDD =
                driver.findElement(By.name("birthday_month"));
        //Select selectMonth = new Select(monthDD);
//        List<WebElement> monthOptions = selectMonth.getOptions();
//        int months = monthOptions.size();
//        System.out.println(months);
//
//        selectMonth.selectByIndex(4);

    }
}
