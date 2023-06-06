package guru;

import com.github.javafaker.Faker;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.ApplicationFlow;
import utilities.Config;
import utilities.Driver;

public class AgileProject {

    @Test
    public void login(){
        Driver.getDriver().get(Config.getValue("guruURL"));
        Faker faker = new Faker();
        Driver.getDriver().findElement(By.xpath("//input[@name='emailid']")).sendKeys(faker.internet().emailAddress());
        Driver.getDriver().findElement(By.name("btnLogin")).click();
        Driver.getDriver().findElement(By.linkText("Agile Project")).click();
        String id = Driver.getDriver().findElement(By.xpath("//ol/li[1]")).getText().substring(9);
        String pas = Driver.getDriver().findElement(By.xpath("//ol/li[2]")).getText().substring(11);
        Driver.getDriver().findElement(By.name("uid")).sendKeys(id);
        Driver.getDriver().findElement(By.name("password")).sendKeys(pas);
        Driver.getDriver().findElement(By.name("btnLogin")).click();
        ApplicationFlow.pause(500);
        String expect = "https://demo.guru99.com/Agile_Project/Agi_V1/customer/Customerhomepage.php";
        Assert.assertEquals("Login functionality failed",expect,Driver.getDriver().getCurrentUrl());

           }

    @After
    public void afterSettings(){
        Driver.quit();
    }
















}
