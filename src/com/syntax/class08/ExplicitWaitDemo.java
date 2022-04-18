package com.syntax.class08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitDemo {

    /*
    click on get new user
    get the first name text
    print it out in console
     */

    static String url = "http://syntaxprojects.com/dynamic-data-loading-demo.php";

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

        //clicking on 'get new user' button:
        WebElement getNewUserBtn = driver.findElement(By.id("save"));
        getNewUserBtn.click();


        //it takes time for the name to load, so we should set an 'explicit wait'!!!!!

        //first we create an object of WebDriverWait class:
        WebDriverWait wait = new WebDriverWait(driver, 20);
        /*
        syntax:
        -'WebDriverWait' is the class.
        -'wait' is the name of the object of WebDriverWait class.
        -'new' = new object.
        -'(driver, 20)': the 'driver' is the name of our WebDriver (what we are telling to wait),
            and the '20' means to wait for 20 seconds.
         */

        //next, we must specify the condition(s) for the WebDriver to wait for:
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[starts-with(text(), 'First Name : ')]")));
        /*
        syntax:
        -'wait': the name of our object of WebDriverWait class that we created above.
        -'.until()': the method we are calling on our WebDriverWait object.
        -'ExpectedConditions':
            class (from Selenium library) we MUST call on in order to use its built-in methods to specify our condition.
        -'.visibilityOfElementLocated()': the built-in method of ExpectedConditions class that we picked
            to use to specify our condition (this one waits until a particular WebElement is visible).
        -'By.xpath("//p[starts-with(text(), 'First Name : ')]")':
            specifying the WebElement that we want to wait on until it is visible.
            (We cannot just use 'WebElement firstName', because that WebElement has not been declared or defined yet,
            and it CANNOT be created yet, because it is not visible for a few seconds.
            That is why we are creating this explicit wait in the first place.)
         */


        //getting the first name text:
        WebElement firstName = driver.findElement(By.xpath("//p[starts-with(text(), 'First Name : ')]"));

        //printing it out in console
        System.out.println(firstName.getText());



        //closing the browser:
        driver.quit();

    }
}
