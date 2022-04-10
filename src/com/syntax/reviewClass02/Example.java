package com.syntax.reviewClass02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Example {

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://syntaxprojects.com/basic-radiobutton-demo.php");

        WebElement femaleBtn = driver.findElement(By.xpath("//input[@value='Female' and @name='optradio']"));

        //check if the radio button is enabled:
        System.out.println("female radio button is enabled: " + femaleBtn.isEnabled());

        //check if radio button is displayed:
        System.out.println("female radio button is displayed: " + femaleBtn.isDisplayed());

        //check if its selected or not:
        System.out.println("female radio button is selected: " + femaleBtn.isSelected());

        System.out.println();

        //check if button is not selected, and if so, click on it
        if (!femaleBtn.isSelected()) {
            femaleBtn.click();
        }
        System.out.println("female radio button is selected: " + femaleBtn.isSelected());

        System.out.println();


        //get all the links in the current webpage and print their text
        List<WebElement> allLink = driver.findElements(By.tagName("a"));

        for(WebElement link : allLink){
            String name = link.getText();
            if(!name.isEmpty()){
                System.out.println(name);
            }
        }

    }
}
