package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Techlistic {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
        driver.manage().window().maximize();

        WebElement dropdown = driver.findElement(By.id("continents"));
        Select continents = new Select(dropdown);
        System.out.println("Default value: " + continents.getFirstSelectedOption().getText());

        List<WebElement> contOptions = continents.getOptions();
        System.out.println("All options:");
        for (WebElement webElement: contOptions){
            System.out.println(webElement.getText());
        }
        if (contOptions.size()==7){
            System.out.println("Test passed");
        }
        else
            System.out.println("Test failed");

        continents.selectByVisibleText("Europe");
        Thread.sleep(1500);



      List<WebElement> dr2 = driver.findElements(By.xpath("//select[@id='selenium_commands']/option"));
        System.out.println(dr2.size());

        for (WebElement webElement: dr2){
            webElement.click();
            }
        }

    }

