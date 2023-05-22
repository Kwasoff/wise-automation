import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class Screensh {
    public static void main(String[] args) throws IOException, InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.instagram.com");

        File f1 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        Files.copy(f1.toPath(), new File("C:\\Users\\iharz\\Desktop\\my automation\\inst.jpg").toPath());

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://youtube.com");
        Thread.sleep(3000);
        File f2 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        Files.copy(f2.toPath(), new File("C:\\Users\\iharz\\Desktop\\my automation\\youtube.jpg").toPath());

        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://google.com");
        Thread.sleep(3000);
        File f3 = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        Files.copy(f3.toPath(), new File("C:\\Users\\iharz\\Desktop\\my automation\\google.jpg").toPath());


        driver.quit();


















    }

}
