package com.syntax.class05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HW {

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

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.facebook.com");
        driver.manage().window().maximize();

        WebElement createNewAccountButton = driver.findElement(By.linkText("Create new account"));
        createNewAccountButton.click();

        Thread.sleep(3000);

        WebElement monthDD = driver.findElement(By.name("birthday_month"));
        Select selectMonth = new Select(monthDD);
        List<WebElement> monthOptions = selectMonth.getOptions();
        int months = monthOptions.size();
        System.out.println("12 'month' options: "+(months==12));

        WebElement dayDD = driver.findElement(By.id("day"));
        Select selectDay = new Select(dayDD);
        List<WebElement> dayOptions = selectDay.getOptions();
        int days = dayOptions.size();
        System.out.println("31 'day' options: "+(days==31));

        WebElement yearDD = driver.findElement(By.id("year"));
        Select selectYear = new Select(yearDD);
        List<WebElement> yearOptions = selectYear.getOptions();
        int years = yearOptions.size();
        System.out.println("115 'year' options: "+(years==115));
        System.out.println("number of 'year' options "+years);


        selectMonth.selectByIndex(4);
        selectDay.selectByValue("6");
        selectYear.selectByValue("1997");

        Thread.sleep(2000);
        driver.quit();

    }
}
