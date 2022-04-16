package com.syntax.class05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class HW3 {
    /*
    Go to ebay.com
    get all the categories and print them in the console
    select Computers/Tables & Networking
    click on search
    verify the header
     */

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.ebay.com/");

        Thread.sleep(2000);

        WebElement categoriesDD = driver.findElement(By.xpath("//select[@aria-label = 'Select a category for search']"));
        Select selectCategory = new Select(categoriesDD);
        List<WebElement> categories = selectCategory.getOptions();

        for(WebElement category : categories){
            String categoryText = category.getText();
            System.out.println(categoryText);
        }

        selectCategory.selectByVisibleText("Computers/Tablets & Networking");

        driver.findElement(By.id("gh-btn")).click();

        Thread.sleep(2000);

        String header = driver.findElement(By.xpath("//span[@class = 'b-pageheader__text']")).getText();

        System.out.println("Header is 'Computers, Tablets & Network Hardware': "
                +header.equals("Computers, Tablets & Network Hardware"));

        driver.quit();

    }

}
