package com.syntax.class08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HW {

    /*
    go to https://the-internet.herokuapp.com/dynamic_controls
    click on checkbox and click on remove
    verify the text
    click on enable verify the textbox is enabled
    enter text and click disable
    verify the textbox is disabled
     */

    static String url = "https://the-internet.herokuapp.com/dynamic_controls";

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

        //clicking on checkbox
        WebElement checkbox = driver.findElement(By.xpath("//input[@type='checkbox']"));
        checkbox.click();

        //clicking on Remove button
        WebElement removeBtn = driver.findElement(By.xpath("//button[text()='Remove']"));
        removeBtn.click();

        //waiting for text to be displayed
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));

        //verifying the text
        WebElement text = driver.findElement(By.id("message"));
        System.out.println("text is displayed: "+text.isDisplayed());
        System.out.println("text says 'It's gone!': "+text.getText().equals("It's gone!"));


        //clicking on enable
        WebElement enableBtn = driver.findElement(By.xpath("//button[contains(text(), 'able')]"));
        enableBtn.click();

        //waiting for text-box to be enabled:
        WebElement textBox = driver.findElement(By.xpath("//form[@id='input-example']/input"));
        wait.until(ExpectedConditions.elementToBeClickable(textBox));

        //verifying the text-box is enabled
        System.out.println("text-box is enabled: "+textBox.isEnabled());

        //entering text
        textBox.sendKeys("Hello!");


        //clicking disable
        enableBtn.click();

        //waiting for disable button to be enabled
        wait.until(ExpectedConditions.elementToBeClickable(enableBtn));

        //verify the text-box is disabled
        System.out.println("text-box is disabled: "+!textBox.isEnabled());


        //closing browser
        driver.quit();

    }
}
