package com.syntax.class05;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class HW2 {
    /*
    Go to facebook sign up page
    Fill out the whole form
    Click signup
     */

    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.facebook.com");
        driver.manage().window().maximize();

        driver.findElement(By.linkText("Create new account")).click();
        Thread.sleep(3000);

        WebElement firstName = driver.findElement(By.name("firstname"));
        firstName.sendKeys("Hassan");

        WebElement lastName = driver.findElement(By.name("lastname"));
        lastName.sendKeys("Nawaz");

        WebElement phoneOrEmail = driver.findElement(By.name("reg_email__"));
        phoneOrEmail.sendKeys("703-703-7033");

        WebElement newPassword = driver.findElement(By.id("password_step_input"));
        newPassword.sendKeys("blahblahblah123!");


        WebElement monthDD = driver.findElement(By.id("month"));
        Select selectMonth = new Select(monthDD);
        selectMonth.selectByValue("5");

        WebElement dayDD = driver.findElement(By.id("day"));
        Select selectDay = new Select(dayDD);
        selectDay.selectByValue("6");

        WebElement yearDD = driver.findElement(By.id("year"));
        Select selectYear = new Select(yearDD);
        selectYear.selectByValue("1997");


        driver.findElement(By.xpath("(//input[@type='radio'])[2]")).click();

        Thread.sleep(3000);

        driver.findElement(By.name("websubmit")).click();

        Thread.sleep(1000);

        driver.quit();

    }
}
