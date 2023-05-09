package saucedemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://saucedemo.com");
        driver.manage().window().maximize();

        WebElement username = driver.findElement(By.id("user-name"));
        username.click();
        username.sendKeys("2342343standard_user");

        WebElement password = driver.findElement(By.name("password"));
        password.click();
        password.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.name("login-button"));
        loginButton.click();

        WebElement errorText = driver.findElement(By.xpath("//h3[@data-test='error']"));
        String message = errorText.getText();
        String expectedMessage = "Wrong username or password";
        if (expectedMessage.equals(message)){
            System.out.println("Error message passed");
        }
        else
            System.out.println("Error message failed");

        Thread.sleep(3000);
        driver.quit();











    }
}
