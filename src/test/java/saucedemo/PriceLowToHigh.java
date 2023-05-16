package saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PriceLowToHigh {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");
        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        WebElement sortingDropdown = driver.findElement(By.className("product_sort_container"));
        sortingDropdown.click();

        Select sorting = new Select(sortingDropdown);
        sorting.selectByVisibleText("Price (low to high)");

        List<WebElement> prices = driver.findElements(By.xpath("//div[@class='inventory_item_price']"));
        for (int i = 0; i < prices.size() - 1; i++){
            String priceWithout$ = prices.get(i).getText().replace("$", "");
            double prodPrices = Double.parseDouble(priceWithout$);

            String priceNext = prices.get(i + 1).getText().replace("$", "");
            double prodPricesNext = Double.parseDouble(priceNext);

            if (prodPrices <= prodPricesNext){
                System.out.println("Test passed");
            }
            else
                System.out.println("Test failed");
        }


    }
}
