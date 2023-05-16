package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.List;

public class MagentoSoftwareTestingBoard {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://magento.softwaretestingboard.com/");
        driver.manage().window().maximize();

        WebElement menButton = driver.findElement(By.linkText("Men"));
        menButton.click();

        WebElement teesLink = driver.findElement(By.linkText("Tees"));
        teesLink.click();

        String currentURL = driver.getCurrentUrl();

        String expectedURL = "https://magento.softwaretestingboard.com/men/tops-men/tees-men.html";

        if (currentURL.equals(expectedURL)){
            System.out.println("We are at the tees page. Test Passed");
        }
        else
            System.out.println("The URL is different. Test Failed");

        //================================================================================================================

        List<WebElement> teesList = driver.findElements(By.xpath("//img[@class='product-image-photo']"));

        List<WebElement> teesPrice = driver.findElements(By.xpath("//span[@class='price-container price-final_price tax weee']"));
        int counter = 0;

        for (int i = 0; i < teesPrice.size(); i++){
            teesPrice = driver.findElements(By.xpath("//span[@class='price-container price-final_price tax weee']"));

            double priceOfTees = Double.parseDouble(teesPrice.get(i).getText().substring(11));

                if (priceOfTees >= 30) {
                    teesList.get(i).click();
                    Thread.sleep(3000);
                    WebElement size = driver.findElement(By.xpath("//div[@id='option-label-size-143-item-169']"));
                    size.click();
                    Thread.sleep(3000);
                    WebElement color = driver.findElement(By.xpath("//div[@id='option-label-color-93-item-49']"));
                    color.click();
                    Thread.sleep(3000);
                    WebElement addB = driver.findElement(By.id("product-addtocart-button"));
                    addB.click();
                    Thread.sleep(3000);
                    counter++;
                    driver.navigate().back();
                    Thread.sleep(3000);
                    driver.navigate().refresh();
                    teesList = driver.findElements(By.xpath("//img[@class='product-image-photo']"));

                }


       }
        System.out.println(counter);
        int cart= Integer.parseInt(driver.findElement(By.xpath("//span[@class='counter-number']")).getText());
        Thread.sleep(3000);
        if (counter==cart){
            System.out.println("Test Passed");
        }
        else
            System.out.println("Test Failed");



    }
}
