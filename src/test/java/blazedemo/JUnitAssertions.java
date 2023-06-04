package blazedemo;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import utilities.Config;
import utilities.Driver;

import java.util.List;

public class JUnitAssertions {

    @Test
    public void playingAround(){
        Driver.getDriver().get(Config.getValue("blazeDemoURL"));
        WebElement from = Driver.getDriver().findElement(By.name("fromPort"));
        Select selectFrom = new Select(from);
        selectFrom.selectByVisibleText("San Diego");
        WebElement to = Driver.getDriver().findElement(By.name("toPort"));
        Select selectTo = new Select(to);
        selectTo.selectByVisibleText("Rome");
        Driver.getDriver().findElement(By.xpath("//div[@class='container']/input")).click();
        List <WebElement> provider = Driver.getDriver().findElements(By.xpath("//tbody//td[3]"));

        for (int i = 0; i < provider.size(); i++){
            provider = Driver.getDriver().findElements(By.xpath("//tbody//td[3]"));
            if (provider.get(i).getText().equals("Lufthansa")){
                Driver.getDriver().findElements(By.xpath("//td[1]/input")).get(i).click();
            }
        }

        Faker faker = new Faker();
        String name = faker.name().fullName();
        Driver.getDriver().findElement(By.id("inputName")).sendKeys(name);
        Driver.getDriver().findElement(By.id("address")).sendKeys(faker.address().streetAddress());
        Driver.getDriver().findElement(By.id("city")).sendKeys(faker.address().city());
        Driver.getDriver().findElement(By.id("state")).sendKeys(faker.address().state());
        Driver.getDriver().findElement(By.id("zipCode")).sendKeys(faker.address().zipCode());

        WebElement cardType = Driver.getDriver().findElement(By.id("cardType"));
        Select selectCardType = new Select(cardType);
        selectCardType.selectByIndex(2);

        Driver.getDriver().findElement(By.id("creditCardNumber")).sendKeys(faker.business().creditCardNumber());
        Driver.getDriver().findElement(By.id("nameOnCard")).sendKeys(name);
        WebElement checkBox = Driver.getDriver().findElement(By.id("rememberMe"));
        checkBox.click();
        Assert.assertTrue(checkBox.isSelected());

        Driver.getDriver().findElement(By.xpath("(//div[@class='controls']/input)[10]")).click();

        String expectedMessage = "Thank you for your purchase today!";
        Assert.assertEquals(expectedMessage,Driver.getDriver().findElement(By.xpath("//h1")).getText());








    }
















}
