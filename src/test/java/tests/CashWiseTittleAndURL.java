package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CashWiseTittleAndURL {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://cashwise.us");
        String expectedTitle = "Cashwise is the best";
        if (!driver.getTitle().equals(expectedTitle)){
            System.out.println("Title test failed");
        }
        else
            System.out.println("Title test passed");
        String expectedURL = "https://cashwise.us/home";
        if (expectedURL.equals(driver.getCurrentUrl())){
            System.out.println("URL test passed succesgully");
        }
        else
            System.out.println("URL test failed");
        System.out.println(driver.getPageSource());
        driver.quit();

    }
}
