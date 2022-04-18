package com.syntax.class08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitTask {

    /*
    click on start button
    get the text
    print it out on console
     */

    static String url = "http://syntaxprojects.com/dynamic-elements-loading.php";

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

        //clicking on start button:
        WebElement startButton = driver.findElement(By.cssSelector("button#startButton"));
        startButton.click();

        //setting explicit wait
        WebDriverWait wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[starts-with(text(), 'Welcome')]")));

        //getting the text:
        WebElement welcomeElement = driver.findElement(By.xpath("//*[starts-with(text(), 'Welcome')]"));
        String welcomeText = welcomeElement.getText();

        //printing out text in the console:
        System.out.println(welcomeText);


        //closing the browser:
        driver.quit();

}
}
