import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;
import java.util.Set;

public class Screenshot {
    public static void main(String[] args) throws IOException, InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.letskodeit.com/");

        driver.findElement(By.linkText("PRACTICE")).click();

        String firstPageID = driver.getWindowHandle();

        Set<String> handles = driver.getWindowHandles();

        for (String id: handles){
            if (!id.equals(firstPageID)){
                driver.switchTo().window(id);
            }
        }

        String secondPageID = driver.getWindowHandle();


        WebElement bmwRadioBut = driver.findElement(By.id("bmwradio"));
        System.out.println("bmwRadioBut is selected: " + bmwRadioBut.isSelected());
        bmwRadioBut.click();
        System.out.println("bmwRadioBut after click is selected: " + bmwRadioBut.isSelected());
        WebElement benzRadioBut = driver.findElement(By.id("benzradio"));
        System.out.println();
        benzRadioBut.click();
        if (benzRadioBut.isSelected()) {
            System.out.println("bmwRadioBut after benz clicked is selected: " + bmwRadioBut.isSelected());
            System.out.println("benzRadioBut is selected: " + benzRadioBut.isSelected());
            System.out.println("Radio button test passed");
        }
        else
            System.out.println("Radio button test failed");

        System.out.println();

        WebElement bmwcheckBox = driver.findElement(By.id("bmwcheck"));
        bmwcheckBox.click();
        WebElement benzcheckBox = driver.findElement(By.id("benzcheck"));
        benzcheckBox.click();

        if (bmwcheckBox.isSelected() && benzcheckBox.isSelected()){
            System.out.println("Check box test passed");
        }
        else
            System.out.println("Check box test failed");

        driver.findElement(By.id("openwindow")).click();

        Set<String> threePages = driver.getWindowHandles();
        System.out.println("Size should be three " + threePages.size());

        for (String id: threePages){
            if (!id.equals(firstPageID) && !id.equals(secondPageID)){
                driver.switchTo().window(id);
            }
        }


        Actions actions = new Actions(driver);
        WebElement js = driver.findElement(By.xpath("(//div[@class='zen-course-thumbnail'])[1]"));
        actions.moveToElement(js).perform();

        File f = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        Files.copy(f.toPath(), new File("C:\\Users\\iharz\\Desktop\\my automation\\myFirstSeleniumScreenshot1.jpg").toPath());

        driver.close();

        driver.switchTo().window(secondPageID);
        System.out.println(driver.getCurrentUrl());

        String expectedURL = "https://www.letskodeit.com/practice";

        if (expectedURL.equals(driver.getCurrentUrl())){
            System.out.println("Switch to second page test passed");
        }
        else
            System.out.println("Switch to second page test failed");

        WebElement cars = driver.findElement(By.id("carselect"));
        Select carsSelector = new Select(cars);

        System.out.println(carsSelector.getFirstSelectedOption().getText());

        List<WebElement> carsOptions = carsSelector.getOptions();
        System.out.println("Cars selector size should be three " + carsOptions.size());

        carsSelector.selectByIndex(1);

        List<WebElement> multipleSelectBox = driver.findElements(By.xpath("//select[@id='multiple-select-example']/option"));
        for (WebElement webElement: multipleSelectBox){
            if (webElement.getText().equals("Orange")){
                webElement.click();
            }
            else if (webElement.getText().equals("Peach")){
                webElement.click();
            }
        }

        driver.findElement(By.id("autosuggest")).sendKeys("CLA");

        WebElement name = driver.findElement(By.id("name"));
        name.sendKeys("Ihar");

        driver.findElement(By.id("confirmbtn")).click();

        Alert alert = driver.switchTo().alert();

        String alertText = alert.getText();

        System.out.println(alertText);

        alert.accept();

        if (alertText.contains("Ihar")){
            System.out.println("Alert test passed");
        }
        else
            System.out.println("Alert test failed");

        WebElement mouseHover = driver.findElement(By.id("mousehover"));

        actions.moveToElement(mouseHover).perform();

        List<WebElement> selectHoverOptions = driver.findElements(By.xpath("//button[@id='mousehover']/../div/a"));
        System.out.println(selectHoverOptions.size());

        File fBeforeReloading = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        Files.copy(fBeforeReloading.toPath(), new File("C:\\Users\\iharz\\Desktop\\my automation\\beforeReload.jpg").toPath());


        for (WebElement webElement: selectHoverOptions){
            if (webElement.getText().equals("Reload")){
                webElement.click();
            }
        }
        Thread.sleep(2000);
        File fAfterReload = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        Files.copy(fAfterReload.toPath(), new File("C:\\Users\\iharz\\Desktop\\my automation\\afterReload.jpg").toPath());


        driver.quit();

    }

}
