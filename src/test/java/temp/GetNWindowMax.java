package temp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetNWindowMax {

    public static void gnm(String url){
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();
    }
}
