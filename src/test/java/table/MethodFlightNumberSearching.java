package table;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class MethodFlightNumberSearching {

   static WebDriver driver;

    public static void main(String[] args) {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://blazedemo.com/reserve.php");

        for (WebElement flights : flightNumbers(200, 500)){
            System.out.println(flights.getText());
        }

    }




    public static List<WebElement> flightNumbers(double from, double to) {

        List<WebElement> prices = driver.findElements(By.xpath("//tbody//td[6]"));
        List<WebElement> flightNumber;
        List<WebElement> flights = new ArrayList<>();
        for (int i = 0; i < prices.size(); i++){

            prices = driver.findElements(By.xpath("//tbody//td[6]"));
            String priceStr = prices.get(i).getText().replace("$", "");
            double priceDoub = Double.parseDouble(priceStr);
            if (priceDoub >= from && priceDoub <= to){
                flightNumber = driver.findElements(By.xpath("//tbody//td[6]/../td[2]"));

                flights.add(flightNumber.get(i));


            }
        }

    return flights;
    }

}