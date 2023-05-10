package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class BlazeDemo {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://blazedemo.com/");
        driver.manage().window().maximize();

        WebElement destOfTheWeekLink = driver.findElement(By.linkText("destination of the week! The Beach!"));
        destOfTheWeekLink.click();

        List <WebElement> text = driver.findElements(By.xpath("//div[@class='container']"));
        System.out.println(text.size());

        String secondElementsText = text.get(1).getText();
        String expectedText = "Destination of the week: Hawaii !";

        if (secondElementsText.equals(expectedText)){
            System.out.println("The destination of the week is Hawaii");
        }
        else
            System.out.println("Wrong destination");


        Thread.sleep(2000);
        driver.quit();


    }
}
