package practice;

import org.checkerframework.checker.units.qual.C;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleOKAlert {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.w3schools.com/js/tryit.asp?filename=tryjs_alert");

        driver.switchTo().frame(driver.findElement(By.id("iframeResult")));
        driver.findElement(By.xpath("//button[.='Try it']")).click();

        Alert alert = driver.switchTo().alert();

        String expectedText = "I am an alert box!";
        if (alert.getText().equals(expectedText)){
            System.out.println("test passed");
        }
        else
            System.out.println("test failed");

        alert.accept();









    }
}
