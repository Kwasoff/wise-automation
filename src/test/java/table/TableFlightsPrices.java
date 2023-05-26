package table;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class TableFlightsPrices {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://blazedemo.com/reserve.php");

        List<WebElement> prices = driver.findElements(By.xpath("//tbody//td[6]"));

        for (WebElement i: prices){
            System.out.println(i.getText().replace("$",""));
        }














    }
}
