package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleCalculator {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://google.com");
        Thread.sleep(1000);
        driver.manage().window().maximize();
        Thread.sleep(1000);
        WebElement searchBar = driver.findElement(By.name("q"));
        searchBar.click();
        Thread.sleep(1000);
        searchBar.sendKeys("calculator");
        Thread.sleep(1000);
        WebElement searchButton = driver.findElement(By.xpath("//input[@value='Google Search']"));
        searchButton.click();
        Thread.sleep(1000);
        WebElement click2 = driver.findElement(By.xpath("//div[@jsname='lVjWed']"));
        click2.click();
        Thread.sleep(1000);
        WebElement multiply = driver.findElement(By.xpath("//div[@jsname='YovRWb']"));
        multiply.click();
        Thread.sleep(1000);
        click2.click();
        Thread.sleep(1000);
        WebElement result = driver.findElement(By.xpath("//div[@jsname='Pt8tGc']"));
        result.click();
        Thread.sleep(2000);
        driver.quit();




    }
}
