package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;

public class EbayEnterSandman {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://ebay.com/");

        driver.manage().window().maximize();

        WebElement searchBar = driver.findElement(By.id("gh-ac"));
        searchBar.click();
        searchBar.sendKeys("vintage metallica enter sandman shirt");

        List<WebElement> dropdown = driver.findElements(By.id("gh-cat"));
        System.out.println(dropdown.size());

        for(WebElement webElement:dropdown){
            if (webElement.getText().equals("Clothing, Shoes & Accessories")){
                webElement.click();
                break;
            }
        }

        WebElement searchButton = driver.findElement(By.id("gh-btn"));
        searchButton.click();

        List <WebElement> listOfShirts = driver.findElements(By.xpath("//ul[@class='srp-results srp-grid clearfix']//*[@class='s-item__price']"));
        System.out.println("Number of results according to the search: " + listOfShirts.size());;

        double [] prices = new double[3];
        for(int i = 0; i < 3; i++){

            String itemPrice = listOfShirts.get(i).getText();
            System.out.println("Item price: " + itemPrice);
            String numbersOnly = itemPrice.replace("$", "").replace(",", "");
            double priceNumber = Double.parseDouble(numbersOnly);
            prices[i] = priceNumber;


        }
        System.out.println(Arrays.toString(prices));
        System.out.println(findTheCheapest(prices));

        if (findTheCheapest(prices) < 300){
            System.out.println("You have 1 min to get your credit card and purchase the t-shirt");
        }
        else
            System.out.println("Still not the price of your dream");



        Thread.sleep(3000);
        driver.quit();




    }

    public static double findTheCheapest(double [] numb){
        double cheapest = Integer.MAX_VALUE;
        for (int i = 0; i < numb.length; i++){
            if (numb[i] < cheapest){
                cheapest = numb[i];
            }

        }
        return cheapest;
    }
}
