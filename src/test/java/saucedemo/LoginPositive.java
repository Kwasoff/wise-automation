package saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class LoginPositive {
    public static void main(String[] args) throws InterruptedException {

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

        WebElement firstProductLink = driver.findElement(By.linkText("Sauce Labs Backpack"));
        firstProductLink.click();
        Thread.sleep(1000);
        driver.navigate().back();
        Thread.sleep(1000);
        driver.findElement(By.linkText("Sauce Labs Bike Light")).click();
        Thread.sleep(1000);
        driver.navigate().back();
        Thread.sleep(1000);
        driver.findElement(By.linkText("Sauce Labs Bolt T-Shirt")).click();
        Thread.sleep(1000);
        driver.navigate().back();
        Thread.sleep(1000);
        driver.findElement(By.linkText("Sauce Labs Fleece Jacket")).click();
        Thread.sleep(1000);
        driver.navigate().back();
        Thread.sleep(1000);
        driver.findElement(By.linkText("Sauce Labs Onesie")).click();
        Thread.sleep(1000);
        driver.navigate().back();
        Thread.sleep(1000);
        driver.findElement(By.linkText("Test.allTheThings() T-Shirt (Red)")).click();
        Thread.sleep(1000);
        driver.navigate().back();
        Thread.sleep(1000);
        System.out.println(driver.getTitle());

        List<WebElement> products = driver.findElements(By.xpath("//div[@class='inventory_item']//button"));
        System.out.println(products.size());

        for (int i = 0; i < 3;i++){
            products.get(i).click();
        }

        WebElement cart = driver.findElement(By.xpath("//a[@class='shopping_cart_link']"));
        cart.click();

        String expectedCartURL = "https://www.saucedemo.com/cart.html";
        String cartURL = driver.getCurrentUrl();

        if (cartURL.equals(expectedCartURL)){
            driver.findElement(By.id("remove-sauce-labs-bolt-t-shirt")).click();
        }
        else
            System.out.println("URL is not same");

        WebElement checkout = driver.findElement(By.id("checkout"));
        checkout.click();

        List<WebElement> checkoutInfo = driver.findElements(By.xpath("//div[@class='checkout_info']//input"));

            checkoutInfo.get(0).click();
            checkoutInfo.get(0).sendKeys("Jack");
            checkoutInfo.get(1).click();
            checkoutInfo.get(1).sendKeys("Jackson");
            checkoutInfo.get(2).click();
            checkoutInfo.get(2).sendKeys("60666");

            WebElement continueButton = driver.findElement(By.id("continue"));
            continueButton.click();

            WebElement finish = driver.findElement(By.xpath("//button[@name='finish']"));
            finish.click();

            WebElement purchaseText = driver.findElement(By.xpath("//div[@class='complete-text']"));
            String happyText = purchaseText.getText();
        System.out.println(happyText);

            String expectedHappyText = "Your order has been dispatched, and will arrive just as fast as the pony can get there!";

        if (happyText.equals(expectedHappyText)){
            System.out.println("Purchase was successfully complete");
        }
        else
            System.out.println("Purchase was failed");

        driver.quit();



    }
}
