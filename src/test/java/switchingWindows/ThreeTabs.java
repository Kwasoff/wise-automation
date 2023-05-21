package switchingWindows;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class ThreeTabs {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.letskodeit.com");
        driver.manage().window().maximize();

        String mainWindowID = driver.getWindowHandle();
        System.out.println(mainWindowID);
        System.out.println(driver.getCurrentUrl());

        WebElement tabButton = driver.findElement(By.linkText("PRACTICE"));
        tabButton.click();

        Set<String> windowHandles = driver.getWindowHandles();
        System.out.println(windowHandles.size());

        for (String id: windowHandles){
            if(!id.equals(mainWindowID)){
                driver.switchTo().window(id);
                break;
            }
        }

        System.out.println(driver.getCurrentUrl());
        String secWinID = driver.getWindowHandle();
        System.out.println(secWinID);

        WebElement newTabBut = driver.findElement(By.id("opentab"));
        newTabBut.click();

        Set<String> windowHandles2 = driver.getWindowHandles();
        System.out.println("Size should be three " + windowHandles2.size());
        System.out.println();

        for (String id: windowHandles2){
            if (!id.equals(mainWindowID) && !id.equals(secWinID)){
                driver.switchTo().window(id);
                break;
            }
        }

        System.out.println(driver.getWindowHandle());
        System.out.println(driver.getCurrentUrl());

        if (driver.getCurrentUrl().equals("https://www.letskodeit.com/courses")){
            System.out.println("Test passed");
        }
        else
            System.out.println("Test failed");

        driver.switchTo().window(mainWindowID);
        System.out.println(driver.getCurrentUrl());
        driver.close();
        driver.switchTo().window(secWinID);
        System.out.println(driver.getCurrentUrl());



    }
}
