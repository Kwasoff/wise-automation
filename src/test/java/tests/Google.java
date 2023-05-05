package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Google {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
        driver.manage().window().maximize();

        if (!driver.getTitle().equals("Hi, Google")){
            System.out.println("Google title is not what we are looking for");
        }
        else
        System.out.println(driver.getTitle());
        driver.navigate().to("https://amazon.com");


        if (!driver.getTitle().equals("Hi, Amazon")){
            System.out.println("Amazon title is not Amazon title we want to see");
        }
        else
        System.out.println(driver.getTitle());
        driver.navigate().back();
        driver.navigate().refresh();
        driver.quit();


    }

}
