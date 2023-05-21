package alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class LocatorsAlertsActions {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://artoftesting.com/sampleSiteForSelenium");
        driver.manage().window().maximize();

        WebElement button = driver.findElement(By.xpath("//button[.='Double-click to generate alert box']"));

        Actions actions = new Actions(driver);
        actions.doubleClick(button).perform();

        Alert alert = driver.switchTo().alert();
        String actualText = alert.getText();
        System.out.println(actualText);

        alert.accept();
        String expectedText = "Welcome to Art of Testing!";

        if (!actualText.equals(expectedText)){
            System.out.println("Test passed");
        }
        else
            System.out.println("Test failed");


    }
}
