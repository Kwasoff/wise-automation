package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class SouceDemoAddingProducts {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();

        WebElement username = driver.findElement(By.xpath("//input[@name='user-name']"));
        username.click();
        username.sendKeys("problem_user");

        WebElement password = driver.findElement(By.xpath("//input[@name='password']"));
        password.click();
        password.sendKeys("secret_sauce");

        WebElement button = driver.findElement(By.xpath("//input[@name='login-button']"));
        button.click();

        List<WebElement> products = driver.findElements(By.xpath("//div[@class='inventory_item']//button"));
        System.out.println(products.size());

        for (int i = 0; i < products.size();i++){
            products.get(i).click();
        }

        WebElement numberOfProductsInCart = driver.findElement(By.xpath("//div[@id='shopping_cart_container']"));
        int numberOfItem = Integer.valueOf(numberOfProductsInCart.getText());
        System.out.println(numberOfItem);
        if (products.size() == numberOfItem){
            System.out.println("Test successfully passed");
        }
        else
            System.out.println("Test failed");

        Thread.sleep(2000);
        driver.quit();
    }
}
