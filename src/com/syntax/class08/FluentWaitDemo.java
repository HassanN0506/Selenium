package com.syntax.class08;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

public class FluentWaitDemo {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        //setting a fluent wait:
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(10))
                .pollingEvery(Duration.ofSeconds(2))
                .ignoring(NoSuchElementException.class);
        /*
        syntax:
        -'Wait': creating an object of Wait Interface.
        -'<WebDriver>': passing a WebDriver as the parameter.
        -'wait': name of my Wait object.

        -'new' = creating a new object.
        -'FluentWait': specifying that it is a FluentWait object (so that we can do a Fluent wait).
        -'(driver)': passing my WebDriver (which is named 'driver') as an argument to the FluentWait object.


        METHOD CHAINING (you can add on as many as you want):

        -'.withTimeout()': calling this method on the wait object
                           so that we can set the maximum TOTAL time limit that we will wait for.
        -'Duration.ofSeconds(10)': specifying that we want to wait for a maximum total of 10 seconds.


        -'.pollingEvery()': calling this method on the wait object so that we can specify how often we want to poll
                            ('polling' means checking again and again for something).
        -'Duration.ofSeconds(2)': specifying that we want to POLL (check again) every 2 seconds.


        -'.ignoring()': calling this method to say "Hey, ignore all of these things whilst this wait is happening".
        -'NoSuchElementException': specifying that I want it to ignore THIS exception.
        -'.class': specifying that I want it to ignore this exception in THIS class.

        * -So, it'll ignore the NoSuchElementException FOR THE DURATION OF THE WAIT.
           If the exception comes up after it times out, THEN it will return that exception.
           But it will ignore it for the time-being, during the wait.
           If you leave out this ignore clause, it will return that exception right away and end the execution!!!!!

        * -'.ignoring()' can only ignore any exception THAT COMES FORM SELENIUM!!!!!

        * -Also, you can use the '.until()' method to specify a particular condition to wait for.

         */

    }
}
