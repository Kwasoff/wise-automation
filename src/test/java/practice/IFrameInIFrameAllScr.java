package practice;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class IFrameInIFrameAllScr {
    public static void main(String[] args) throws IOException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.hyrtutorials.com/p/frames-practice.html");

        driver.switchTo().frame(driver.findElement(By.id("frm2")));
        driver.findElement(By.id("firstName")).sendKeys("Kiki");
        driver.findElement(By.id("lastName")).sendKeys("Eska");
        WebElement femRadioB = driver.findElement(By.id("femalerb"));
        femRadioB.click();
        femRadioB.isSelected();

        WebElement engCeckBox = driver.findElement(By.id("englishchbx"));
        engCeckBox.click();
        engCeckBox.isSelected();

        WebElement frCheckBox = driver.findElement(By.id("frenchchbx"));
        frCheckBox.click();
        frCheckBox.isSelected();

        driver.findElement(By.id("email")).sendKeys("abc@gmail.com");

        driver.switchTo().parentFrame();

        Actions actions = new Actions(driver);

        driver.findElement(By.xpath("//h1[contains(text(),'Frames Practice')]")).click();

        actions.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).perform();

        File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        Files.copy(f.toPath(), new File("C:\\Users\\iharz\\Desktop\\my automation\\scrAll.png").toPath());

        driver.quit();







    }
}
