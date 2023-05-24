package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Set;

public class HandlePopup {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(" https://demo.guru99.com/popup.php");

        String firstWindowHandle = driver.getWindowHandle();

        driver.findElement(By.xpath("//a[.='Click Here']")).click();

        Set<String> listID = driver.getWindowHandles();
        System.out.println("2? " + listID.size());

        for (String id: listID){
            if (!id.equals(firstWindowHandle)){
                driver.switchTo().window(id);
            }
        }

        driver.findElement(By.name("emailid")).sendKeys("abc@gmail.com");
        driver.findElement(By.name("btnLogin")).click();

        driver.close();
        driver.switchTo().window(firstWindowHandle);

        if (driver.getWindowHandle().equals(firstWindowHandle)){
            System.out.println("test passed");
        }
        else
            System.out.println("test failed");

    }
}
