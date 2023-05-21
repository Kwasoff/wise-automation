package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class HoveringMenu {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://artoftesting.com/sampleSiteForSelenium");
        driver.manage().window().maximize();

        Actions actions = new Actions(driver);
        List<WebElement> menu = driver.findElements(By.xpath("//div[@id='primary-menu']/ul/li"));
        for (int i = 0; i < menu.size()-1; i++){
            actions.moveToElement(menu.get(i)).perform();
            Thread.sleep(1000);
        }





    }
}
