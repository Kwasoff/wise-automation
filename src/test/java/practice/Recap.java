package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Recap {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://chercher.tech/practice/practice-dropdowns-selenium-webdriver");

        WebElement firstDrop = driver.findElement(By.xpath("//select[@id='first']"));

        Select first = new Select(firstDrop);

        List<WebElement> firstList = first.getOptions();
        System.out.println(firstList.size());

        if (firstList.size()==4){
            System.out.println("First test passed");
        }
        else
            System.out.println("First test failed");

        for (WebElement i: firstList){
            if (i.getText().equals("Yahoo")){
                i.click();
            }
        }


        WebElement animals = driver.findElement(By.xpath("//select[@id='animals']"));

        Select animalsSelector = new Select(animals);

        List<WebElement> animList = animalsSelector.getOptions();

        if (animList.size()==4){
            System.out.println("Animal size test passed");
        }
        else
            System.out.println("Animal test failed");

        for (WebElement i: animList){
            if (i.getText().equals("Baby Cat")){
                i.click();
            }
        }


        List<WebElement> foodItems = driver.findElements(By.xpath("//select[@id='second']/option"));
        if (foodItems.size()==4) {
            System.out.println("Second test passed");
            for (WebElement i : foodItems) {
                i.click();
                System.out.println(i.getText());
            }
        }
        else
            System.out.println("Second test failed");











    }
}
