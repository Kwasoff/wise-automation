package tests;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class LocatorsWithJanarbek {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://saucedemo.com");
        Thread.sleep(1000);

        WebElement userNameInput = driver.findElement(By.name("user-name"));
        Thread.sleep(1000);

        userNameInput.click();
        Thread.sleep(1000);

        userNameInput.sendKeys("standard_user");
        Thread.sleep(1000);

        WebElement password = driver.findElement(By.id("password"));
        Thread.sleep(1000);

        password.click();
        Thread.sleep(1000);

        password.sendKeys("secret_sauce");
        Thread.sleep(1000);


        WebElement loginButton = driver.findElement(By.xpath("//input[@name='login-button']"));
        Thread.sleep(1000);

        loginButton.click();
        Thread.sleep(1000);

        WebElement firstProduct = driver.findElement(By.xpath("//div[@class='inventory_item']//div[.='Sauce Labs Backpack']"));
        System.out.println(firstProduct.getText());


        List<WebElement> products = driver.findElements(By.xpath("//div[@class='inventory_item']//button"));
        System.out.println(products.size());

        for (int i = 0; i < 4; i++){
            products.get(i).click();
        }

        driver.quit();



    }
}
