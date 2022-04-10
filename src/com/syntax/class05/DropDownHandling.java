package com.syntax.class05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class DropDownHandling {

    public static String url = "https://www.syntaxprojects.com/basic-select-dropdown-demo.php";

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        WebElement daysDD = driver.findElement(By.id("select-demo"));
        //select class only works if the DD menu has a select tag
        //otherwise, we'd have to use a list and loop through it
        Select select = new Select(daysDD);
        //we have to pass a dropdown menu to its constructor

        select.selectByIndex(3); //indexing starts from 0

        Thread.sleep(1000);

        select.selectByVisibleText("Thursday");
        //"visible text" is what you can see on the front end (not html)
        //preferred way

        Thread.sleep(1000);

        select.selectByValue("Sunday");

        List<WebElement> allOptions = select.getOptions();
        //.getOptions() method gets all the options from out 'select' Selector
        //in which we passed the daysDD, so it'll get all the options from the daysDD

        int size = allOptions.size();
        System.out.println(size);

        for(int i= 0; i < size; i++){
//            WebElement option = allOptions.get(i);
//            System.out.println(option.getText());
            //or you can combine them into 1 statement:
            String option = allOptions.get(i).getText();
            //String because you're storing the text value of that WebElement
            System.out.println(option);

            select.selectByIndex(i);

            Thread.sleep(1000);
        }
    }
}
