package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {
    public static void main(String[] args) throws InterruptedException {


        WebDriver driver = new ChromeDriver();
        driver.get("https://artoftesting.com/sampleSiteForSelenium");
        driver.manage().window().maximize();
        Thread.sleep(3000);

        Actions actions = new Actions(driver);

        WebElement link = driver.findElement(By.linkText("Selenium Sample Script"));

        WebElement target = driver.findElement(By.name("firstName"));

        Thread.sleep(3000);
        actions.dragAndDrop(link,target).perform();




    }
}
