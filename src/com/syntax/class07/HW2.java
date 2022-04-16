package com.syntax.class07;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class HW2 {
    /*
    HW
    navigate to http://www.uitestpractice.com/Students/Contact
    click on the link
    get text
    print out in the console
     */

    static String url = "http://www.uitestpractice.com/Students/Contact";

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebElement link = driver.findElement(By.linkText("This is a Ajax link"));
        link.click();

        WebElement textBox = driver.findElement(By.cssSelector("div.ContactUs"));
        System.out.println(textBox.getText());

        driver.quit();

    }
}
