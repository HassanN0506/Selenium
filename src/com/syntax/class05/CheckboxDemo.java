package com.syntax.class05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class CheckboxDemo {

    public static String url = "https://www.syntaxprojects.com/basic-checkbox-demo.php";

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(url);

        //locating checkboxes and storing them in the list
        List<WebElement> optionsCheckBoxes= driver.findElements(By.cssSelector("input[class='cb1-element']"));

        int size = optionsCheckBoxes.size();
        System.out.println(size);

        //looping through each element from the list
        for(WebElement option:optionsCheckBoxes){

            String checkBoxValue = option.getAttribute("value");

            if(checkBoxValue.equals("Option-2")){
                option.click();
                break;
            }
        }


    }
}
