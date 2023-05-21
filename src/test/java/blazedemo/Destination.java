package blazedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Destination {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://blazedemo.com/");
        driver.manage().window().maximize();

        WebElement destinationDropdown = driver.findElement(By.name("toPort"));

        Select destinationCities = new Select(destinationDropdown);

        destinationCities.selectByVisibleText("Berlin");
        WebElement selected = destinationCities.getFirstSelectedOption();

        if (selected.getText().equals("Berlin")){
            System.out.println("Select functionality passed");
        }
        else
        System.out.println("Select functionality failed");








    }
}
