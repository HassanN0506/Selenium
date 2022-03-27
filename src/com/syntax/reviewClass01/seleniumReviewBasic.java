package com.syntax.reviewClass01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class seleniumReviewBasic {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://demoqa.com/text-box");
//        WebElement username = driver.findElement(By.id("userName"));
//        username.sendKeys("abracadabra");
//        Thread.sleep(2000);
//        username.clear();
//        username.sendKeys("supercalifragilisticexpialidocious");
        WebElement username = driver.findElement(By.xpath("//input[@id='userName']"));
        username.sendKeys("hello there");


    }
}
