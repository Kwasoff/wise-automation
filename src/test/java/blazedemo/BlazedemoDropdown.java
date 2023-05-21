package blazedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.security.Key;
import java.util.ArrayList;
import java.util.List;

public class BlazedemoDropdown {
    public static void main(String[] args) throws InterruptedException {

        List <String> expectedFromCities = new ArrayList<>();
        expectedFromCities.add("Paris");
        expectedFromCities.add("Philadelphia");
        expectedFromCities.add("Boston");
        expectedFromCities.add("Portland");
        expectedFromCities.add("San Diego");
        expectedFromCities.add("Mexico City");
        expectedFromCities.add("São Paolo");


        WebDriver driver = new ChromeDriver();
        driver.get("https://blazedemo.com/");
        driver.manage().window().maximize();

        WebElement fromPornDropdown = driver.findElement(By.xpath("//select[@name='fromPort']"));

        WebElement toPornDropdown = driver.findElement(By.xpath("//select[@name='toPort']"));

        Select fromCities = new Select(fromPornDropdown);
        Select toCities = new Select(toPornDropdown);

        String fromDefaultValue = fromCities.getFirstSelectedOption().getText();
        String toDefaultValue = toCities.getFirstSelectedOption().getText();

        System.out.println(fromDefaultValue);
        System.out.println(toDefaultValue);

        List<WebElement> fromOptions = fromCities.getOptions();
        System.out.println("All options");
        System.out.println(fromOptions);
        if (fromOptions.size()==expectedFromCities.size()){
            System.out.println("From cities option size passed");
        }
        else
            System.out.println("From cities size failed");
        for (WebElement option : fromOptions) {
            if (expectedFromCities.contains(option.getText())){
                System.out.println("Cities passed");
            }
            else
                System.out.println("Cities failed");

            fromCities.selectByVisibleText("Boston");
            Thread.sleep(2000);
            fromCities.selectByIndex(4);
            Thread.sleep(2000);
            fromCities.selectByValue("Mexico City");




        }
    }
}
