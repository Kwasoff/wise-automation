package practice;

import org.checkerframework.checker.units.qual.K;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

public class PracticeEverything {
    public static void main(String[] args) throws InterruptedException, IOException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.letskodeit.com/practice");

        driver.findElement(By.id("enabled-example-input")).sendKeys("bury tomorrow");

        driver.findElement(By.id("disabled-button")).click();

//        driver.findElement(By.id("enabled-example-input")).sendKeys(" the best");  ElementNotInteractableException

        driver.findElement(By.id("enabled-button")).click();

        driver.findElement(By.id("enabled-example-input")).sendKeys(" the best");

        driver.findElement(By.id("displayed-text")).sendKeys("kiss");

        driver.findElement(By.id("hide-textbox")).click();

        driver.findElement(By.id("show-textbox")).click();

        driver.findElement(By.id("name")).sendKeys("lion");

        driver.findElement(By.id("confirmbtn")).click();

        Alert alert = driver.switchTo().alert();

        if (alert.getText().contains("lion")) {
            System.out.println(alert.getText());
        }
        else
            System.out.println("Alert text doesn't contain LION");

        alert.accept();


        driver.switchTo().frame("courses-iframe");

        Actions actions = new Actions(driver);

        actions.scrollByAmount(0,500).perform();

        List<WebElement> menuList = driver.findElements(By.xpath("//div[@id='navbar-inverse-collapse']//a"));
        System.out.println("MenuList size should be 6 " + menuList.size());



        for (WebElement webElement: menuList){
            actions.moveToElement(webElement).perform();
            Thread.sleep(2000);
        }

        driver.switchTo().parentFrame();

        WebElement hoverButton = driver.findElement(By.id("mousehover"));

        actions.moveToElement(hoverButton).perform();

       driver.findElement(By.xpath("//div[@class='mouse-hover']/div/a[1]")).click();

       driver.switchTo().newWindow(WindowType.TAB);
       driver.get("https://blazedemo.com/");

        driver.findElement(By.linkText("destination of the week! The Beach!")).click();

        actions.scrollByAmount(0,700).perform();

        File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        Files.copy(f.toPath(), new File("C:\\Users\\iharz\\Desktop\\my automation\\scr.jpg").toPath());


    }
}
