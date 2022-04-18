package com.syntax.class08;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.List;

public class HandleStaticWebTables {

    static String url = "http://syntaxprojects.com/table-search-filter-demo.php";

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);

        //Storing each row element of the table inside a list:
        List<WebElement> rowData = driver.findElements(By.xpath("//table[@id='task-table']/tbody/tr"));
        System.out.println("# of rows: "+rowData.size());
        System.out.println();

        //iterating through to get the text from each row
        Iterator<WebElement> itr = rowData.iterator();
        while(itr.hasNext()){
            WebElement row = itr.next();
            String rowText = row.getText();
            System.out.println(rowText);
            System.out.println();
        }

        System.out.println("---------------------------------------------------------------------");

        //Storing each Header element of the table inside a list:
        List<WebElement> columnsData = driver.findElements(By.xpath("//*[@id='task-table']/thead/tr/th"));
        System.out.println("# of columns: "+columnsData.size());
        System.out.println();

        //looping through to get the text from each column of the Header
        for(WebElement column : columnsData){
            String columnText = column.getText();
            System.out.println(columnText);
            System.out.println();
        }


        /*
        We can get the data of each COLUMN by making a list of rowData AND SPECIFYING THE COLUMN'S INDEX
            -example: //table[@id='task-table']/tbody/tr[2]
        And then simply looping through each row
         */

    }
}
