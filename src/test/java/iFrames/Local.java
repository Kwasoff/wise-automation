package iFrames;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.awt.*;
import java.util.List;
import java.util.Set;

public class Local {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("file:///C:/Users/iharz/Desktop/my%20automation/EssenDoc.html");

        WebElement secondFrame = driver.findElement(By.xpath("//iframe[2]"));
        driver.switchTo().frame(secondFrame);
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        driver.findElement(By.id("password")).sendKeys("secret_sauce");

        driver.findElement(By.id("login-button")).click();

        driver.switchTo().parentFrame();

        WebElement thirdFrame = driver.findElement(By.xpath("//iframe[3]"));

        driver.switchTo().frame(thirdFrame);

        driver.findElement(By.id("confirmbtn")).click();

        Alert alert = driver.switchTo().alert();

        System.out.println(alert.getText());

        alert.accept();

        Actions actions = new Actions(driver);
        actions.scrollByAmount(0,  700).perform();
        Thread.sleep(3000);
        driver.switchTo().frame("courses-iframe");

        List<WebElement> hoveringMenu = driver.findElements(By.xpath("//div[@id='navbar-inverse-collapse']/ul//a"));
        System.out.println(hoveringMenu.size());

        for (WebElement i: hoveringMenu){
            actions.moveToElement(i).perform();
            Thread.sleep(1500);
        }



    }
}
