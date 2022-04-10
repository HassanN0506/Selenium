package com.syntax.class05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AmazonDropdown {
    public static String url = "https://www.amazon.com/";

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        WebElement departmentsDD = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(departmentsDD);
        List<WebElement> allDepartments = select.getOptions();

        for(WebElement department:allDepartments){
            String departmentText = department.getText();
            System.out.println(departmentText);
        }

        select.selectByValue("search-alias=appliances");
        //make sure you get the value's 'address', not the value's text


    }
}
