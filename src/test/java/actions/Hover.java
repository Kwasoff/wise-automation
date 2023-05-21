package actions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Hover {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://artoftesting.com/sampleSiteForSelenium");
        driver.manage().window().maximize();

        Actions actions = new Actions(driver);
        WebElement automation = driver.findElement(By.xpath("(//*[contains(text(),'Automation')])[3]"));
        Thread.sleep(1000);
        actions.moveToElement(automation).perform();

//        WebElement hz = driver.findElement(By.xpath("//a[.='Cucumber Tutorial']"));           just click
//        hz.click();

        List<WebElement> options = driver.findElements(By.xpath("//li[@id='menu-item-98']/ul/li"));
        for (WebElement webElement1: options){
            if (webElement1.getText().equals("Cucumber Tutorial")){
                webElement1.click();
            }
        }


    }
}
