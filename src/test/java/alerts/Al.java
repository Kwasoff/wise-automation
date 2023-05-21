package alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Al {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://artoftesting.com/sampleSiteForSelenium");
        driver.manage().window().maximize();

        WebElement alertBut = driver.findElement(By.xpath("//button[.='Generate Confirm Box']"));
        alertBut.click();

        Alert alert = driver.switchTo().alert();
        System.out.println(alert.getText());
        alert.dismiss();

        Actions actions = new Actions(driver);
        actions.scrollToElement(alertBut);

        String expectedResult = "You pressed Cancel!";

        WebElement actualResult = driver.findElement(By.xpath("//p[@id='demo']"));
        String actRes = actualResult.getText();
        if (expectedResult.equals(actRes)){
            System.out.println("Test passed");
        }
        else
            System.out.println("Test failed");

    }
}
