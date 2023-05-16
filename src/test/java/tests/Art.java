package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Art {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://artoftesting.com/sampleSiteForSelenium");
        driver.manage().window().maximize();

        WebElement testingTypesDropdown = driver.findElement(By.id("testingDropdown"));
        Select testingTypes = new Select(testingTypesDropdown);

        String defaultValue = testingTypes.getFirstSelectedOption().getText();

        String expectedDefaultOption = "Automation Testing";
        if (expectedDefaultOption.equals(defaultValue)){
            System.out.println("Default option passed");
        }
        else
            System.out.println("Default option failed");

        List<WebElement> options = testingTypes.getOptions();
        System.out.println("All options:\n");

        for (WebElement webElement: options){
            System.out.println(webElement.getText());
        }

        testingTypes.selectByIndex(2);

    }

}
