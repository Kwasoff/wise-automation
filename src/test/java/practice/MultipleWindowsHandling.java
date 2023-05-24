package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Set;

public class MultipleWindowsHandling {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("http://www.w3schools.com/tags/tryit.asp?filename=tryhtml_link_target");

        String firstWindowID = driver.getWindowHandle();
        System.out.println("It is first window handle: " + firstWindowID);

        WebElement iframe12 = driver.findElement(By.id("iframeResult"));
        driver.switchTo().frame(iframe12);

        driver.findElement(By.xpath("//a[.='Visit W3Schools.com!']")).click();

        Set<String> listOfIDs = driver.getWindowHandles();
        System.out.println("Size of list should be 2: " + listOfIDs.size());

        driver.switchTo().parentFrame();

        for (String i: listOfIDs){
            if (!i.equals(firstWindowID)){
                driver.switchTo().window(i);
            }
        }

        System.out.println("Second window handle: " + driver.getWindowHandle());
        Thread.sleep(3000);
        driver.findElement(By.xpath("//div[@class='w3-bar w3-card-2 notranslate w3-white']/a")).click();

        driver.switchTo().window(firstWindowID);

        if (driver.getWindowHandle().equals(firstWindowID)){
            System.out.println("test passed");
        }
        else
            System.out.println("test failed");

        String buttonText = "Run ❯";

        if (driver.findElement(By.id("runbtn")).getText().equals(buttonText)){
            System.out.println("button test passed");
        }
        else
            System.out.println("button test failed");

        driver.quit();

    }
}
