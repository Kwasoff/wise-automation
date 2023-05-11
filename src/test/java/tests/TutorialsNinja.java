package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class TutorialsNinja {
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.get("https://tutorialsNinja.com/demo/");
        driver.manage().window().maximize();

        List<WebElement> menuButtons = driver.findElements(By.xpath("//ul[@class='nav navbar-nav']/li"));
        System.out.println(menuButtons.size());
        if (menuButtons.size() == 8){
            System.out.println("Test successfully passed");
        }
        else
            System.out.println("Test failed");

        List <WebElement> currencies = driver.findElements(By.xpath("//div[@class='btn-group']//ul/li"));
        System.out.println(currencies.size());

        if (currencies.size() == 3){
            System.out.println("Currencies test passed");
        }
        else
            System.out.println("Currencies test failed");

//        WebElement myAccButton = driver.findElement(By.xpath("(//*[.='My Account'])[1]"));
//        myAccButton.click();
//
//        List <WebElement> register = driver.findElements(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']/li"));
//        System.out.println(register.size());
//        Thread.sleep(1000);
//
//        for (WebElement webElement:register){
//            if (webElement.getText().equals("Register")){
//                webElement.click();
//                break;
//            }
//        }
//        Thread.sleep(2000);
//
//        WebElement firstName = driver.findElement(By.id("input-firstname"));
//        firstName.click();
//        firstName.sendKeys("Jack");
//
//        WebElement lastName = driver.findElement(By.id("input-lastname"));
//        lastName.click();
//        lastName.sendKeys("Jackson");
//
//        WebElement email = driver.findElement(By.id("input-email"));
//        email.click();
//        email.sendKeys("Jackson@gmail.com");
//
//        WebElement phone = driver.findElement(By.id("input-telephone"));
//        phone.click();
//        phone.sendKeys("3124567890");
//
//        WebElement password = driver.findElement(By.id("input-password"));
//        password.click();
//        password.sendKeys("123456q");
//
//        WebElement confirmPassword = driver.findElement(By.id("input-confirm"));
//        confirmPassword.click();
//        confirmPassword.sendKeys("123456q");
//
//        WebElement yesWindow = driver.findElement(By.name("newsletter"));
//        yesWindow.click();
//
//        WebElement agreeWindow = driver.findElement(By.name("agree"));
//        agreeWindow.click();
//
//        WebElement continueButton = driver.findElement(By.xpath("//input[@class='btn btn-primary']"));
//        continueButton.click();


        WebElement myAccButton = driver.findElement(By.xpath("(//*[.='My Account'])[1]"));
        myAccButton.click();

        List <WebElement> register = driver.findElements(By.xpath("//ul[@class='dropdown-menu dropdown-menu-right']/li"));

        Thread.sleep(1000);

        for (WebElement webElement:register){
            if (webElement.getText().equals("Login")){
                webElement.click();
                break;
            }
        }
        Thread.sleep(2000);

        WebElement loginEmail = driver.findElement(By.id("input-email"));
        loginEmail.click();
        loginEmail.sendKeys("Jackson@gmail.com");

        WebElement loginPassword = driver.findElement(By.id("input-password"));
        loginPassword.click();
        loginPassword.sendKeys("123456q");

        WebElement loginButton = driver.findElement(By.xpath("//input[@class='btn btn-primary']"));
        loginButton.click();

        String currentURL = driver.getCurrentUrl();

        Thread.sleep(2000);

        String expectedURL = "https://tutorialsninja.com/demo/index.php?route=account/account";

        if (currentURL.equals(expectedURL)){
            System.out.println("Successful login");
        }
        else
            System.out.println("Login test failed");

        driver.quit();

    }
}
