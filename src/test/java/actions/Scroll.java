package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Scroll {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://artoftesting.com/sampleSiteForSelenium");
        driver.manage().window().maximize();

        Actions actions = new Actions(driver);

        WebElement link = driver.findElement(By.linkText("Selenium Tutorial"));
        System.out.println(link.getLocation());

        actions.scrollByAmount(0,1500).perform();
        actions.scrollByAmount(0,-400).perform();
//        actions.scrollByAmount(link.getLocation().getX(), link.getLocation().getY()).perform();

//        actions.scrollToElement(link).perform();
//        Thread.sleep(2000);                                               scroll to the element
//        link.click();


    }
}
