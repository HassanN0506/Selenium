package com.syntax.reviewClass02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Example2 {

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://syntaxprojects.com/basic-checkbox-demo.php");

        //print the message that comes up when you click the checkbox
        WebElement checkbox1 = driver.findElement(By.cssSelector("input#isAgeSelected"));

        if (!checkbox1.isSelected()) {
            checkbox1.click();
        }

        Thread.sleep(2000);

        WebElement message = driver.findElement(By.xpath("//div[@id='txtAge']"));

        System.out.println(message.getText());

        //get all the available options
//        List<WebElement> checkboxs = driver.findElements(By.xpath("//input[@class='cb1-element']"));
//        for(WebElement checkbox : checkboxs){
//            checkbox.click();
//        }
//        Thread.sleep(2000);
//        for(WebElement checkbox : checkboxs){
//            checkbox.click();
//        }


        //trying to get it to check the boxes backwards
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@class='cb1-element']"));
        for(int i = checkboxes.size()-1; i>=0; i--){
            checkboxes.get(i).click();
        }
        Thread.sleep(2000);
        for(int i = checkboxes.size()-1; i>=0; i--){
            checkboxes.get(i).click();
        }

    }
}
