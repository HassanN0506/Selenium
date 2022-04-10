package com.syntax.class04;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class HW {
    public static void main(String[] args) throws InterruptedException {
        /*
        Open chrome browser
        Go to "http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login"
        Enter valid username and password (username - Admin, password - Hum@nhrm123)
        Click on login button
        Then verify Syntax Logo is displayed.
         */
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().window().maximize();

        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("Hum@nhrm123");
        driver.findElement(By.id("btnLogin")).click();

        Thread.sleep(2000);

        WebElement syntaxLogo = driver.findElement(By.xpath("//img[@alt = 'OrangeHRM']"));

        System.out.println("Syntax logo is displayed: "+syntaxLogo.isDisplayed());

        driver.quit();
    }
}

class HW2{
    public static void main(String[] args) {
        /*
        Amazon link count:
        Open chrome browser
        Go to "https://www.amazon.com/"
        Get all links
        Get number of links that has text
        Print to console only the links that has text
         */
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();

        List<WebElement> allLinks = driver.findElements(By.tagName("a"));
        System.out.println("Number of links: " + allLinks.size());

        for (WebElement link : allLinks){
            String linkText = link.getText();
            String fullLink = link.getAttribute("href");
            if(!linkText.isEmpty()) {
                System.out.println(linkText+" - "+fullLink);
            }
        }

        driver.quit();
    }
}

class HW3{
    public static void main(String[] args) {
        /*
        HRMS Application Negative Login:
        Open chrome browser
        Go to "http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login"
        Enter valid username
        Leave password field empty
        Click on login button
        Verify error message with text "Password cannot be empty" is displayed.
         */
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
        driver.manage().window().maximize();

        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("btnLogin")).click();

        WebElement errorMessage = driver.findElement(By.id("spanMessage"));

        System.out.println("'Password cannot be empty' is displayed: "+errorMessage.isDisplayed());

        driver.quit();
    }
}