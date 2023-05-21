package saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class VerifyButton {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://saucedemo.com");
        driver.manage().window().maximize();
        WebElement username = driver.findElement(By.id("user-name"));
        username.sendKeys("standard_user");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        if (driver.getCurrentUrl().equals("https://www.saucedemo.com/inventory.html")){
            System.out.println("URL test passed");
        }
        else
            System.out.println("URL test failed");

        WebElement addToCartButton = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
        String firstText = addToCartButton.getText();
        addToCartButton.click();

        WebElement firstButton = driver.findElement(By.xpath("(//div[@class='pricebar'])[1]/button"));
        System.out.println(firstButton.getText());

        String currentResult = firstButton.getText();
        String expectedResult = "Remove";

        if (!currentResult.equals(firstText) && currentResult.equals(expectedResult)){
            System.out.println("Test successfully passed ");
        }
        else
            System.out.println("Test failed");

        List<WebElement> dropdown = driver.findElements(By.xpath("//select[@class='product_sort_container']/option"));
        System.out.println(dropdown.size());

        for (WebElement webElement: dropdown){
            if (webElement.getText().equals("Price (low to high)")){
                webElement.click();
                break;
            }
        }


    }
}
