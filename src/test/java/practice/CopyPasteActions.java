package practice;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CopyPasteActions {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://wikipedia.com");

        WebElement searchBar = driver.findElement(By.id("searchInput"));
        searchBar.sendKeys("Muhammad Ali");
        searchBar.sendKeys(Keys.ENTER);

        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).sendKeys("a").sendKeys("c").keyUp(Keys.CONTROL).perform();

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://wordcounter.net");

        WebElement box = driver.findElement(By.id("box"));
        actions.keyDown(box, Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();

        WebElement asd = driver.findElement(By.xpath("(//span[@class='counted'])[1]"));

        if (asd.getText().equals("25,085 words 157,197 characters")){
            System.out.println("test passed");
        }
        else
            System.out.println("test failed");













    }
}
