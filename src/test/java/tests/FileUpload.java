package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUpload {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/upload");
        driver.manage().window().maximize();


        WebElement uplArea = driver.findElement(By.id("file-upload"));
        uplArea.sendKeys("C:\\Users\\iharz\\Desktop\\Screenshot 2022-04-02 131315.png");

        WebElement fileSubmitButton = driver.findElement(By.id("file-submit"));
        fileSubmitButton.click();



    }
}
