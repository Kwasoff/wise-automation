package guru;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FakeData {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.guru99.com/");

        Faker faker = new Faker();


        driver.findElement(By.name("emailid")).sendKeys(faker.internet().emailAddress());
        driver.findElement(By.name("btnLogin")).click();

        List<WebElement> tt = driver.findElements(By.xpath("(//table)[2]//td[2]"));

        for (WebElement i: tt){
            System.out.println(i.getText());
        }
        driver.quit();


    }
}
